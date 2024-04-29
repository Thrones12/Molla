package DaiHoc.Molla.controller.web;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.Utils.CookieManager;
import DaiHoc.Molla.entity.Bill;
import DaiHoc.Molla.entity.Cart;
import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.LineItem;
import DaiHoc.Molla.entity.PromotionalCode;
import DaiHoc.Molla.entity.Transaction;
import DaiHoc.Molla.entity.User;
import DaiHoc.Molla.service.IBillService;
import DaiHoc.Molla.service.ICartService;
import DaiHoc.Molla.service.ICategoryService;
import DaiHoc.Molla.service.ILineItemService;
import DaiHoc.Molla.service.IPromotionalCodeService;
import DaiHoc.Molla.service.ITransactionService;
import DaiHoc.Molla.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class CheckOutController {
	@Autowired
	private ICartService cartService;
	@Autowired
	private ICategoryService cateService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IPromotionalCodeService codeService;
	@Autowired
	private ITransactionService transService;
	@Autowired
	private IBillService billService;
	@Autowired
	private ILineItemService lineService;
	@GetMapping("checkout")
	public String getCheckout(@RequestParam String carts_id, @RequestParam Float ship, ModelMap model) {
		String[] str_cartsId = carts_id.split(",");
		List<Cart> carts = new ArrayList<Cart>();
		Float subtotal = 0F;
		for (String cart_id : str_cartsId) {
			Cart cart = cartService.findOne(Long.parseLong(cart_id));
			carts.add(cart);
			subtotal += cart.getLineItem().getSubtotal();
		}
		model.addAttribute("carts", carts);
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("ship", ship);
		model.addAttribute("total", subtotal+ship);
		return "web/views/checkout";
	}
	@SuppressWarnings("unchecked")
	@PostMapping("checkout")
	public String postCheckout(ModelMap model
			,HttpServletRequest request) {
		model.addAttribute("categories", (List<Category>) cateService.getAll().get());
		Long user_id = Long.parseLong(CookieManager.getCookieValue(request, "user_id"));
		// Tạo bill
		Bill bill = new Bill();
		bill.setUser((User) userService.getOne(user_id).get());
		bill.setProduct_price(Float.parseFloat(request.getParameter("subtotal")));
		bill.setShip(Float.parseFloat(request.getParameter("ship")));
		bill.setTotal_price(Float.parseFloat(request.getParameter("total")));
		bill.setBill_date(Date.valueOf(LocalDate.now()));
		bill.setState(0);
		bill.setReceiver(request.getParameter("name"));
		String address_ship = "";
		address_ship += (request.getParameter("more_address")!="") ? request.getParameter("more_address") + ", " : "";
		address_ship
				+= request.getParameter("address") + ", "
				+ request.getParameter("Province") + ", "
				+ request.getParameter("city") + ", "
				+ request.getParameter("country")
				;
		bill.setAddress_shipment(address_ship);
		bill.setPhone_shipment(request.getParameter("Phone"));
		bill.setEmail(request.getParameter("email"));
		bill.setNote(request.getParameter("note"));
		if (request.getParameter("code") != null) {
			bill.setPromotionalCode((PromotionalCode) codeService.getOne(Long.parseLong(request.getParameter("code"))).get());
		}
		
		billService.create(Optional.ofNullable(bill));


		String[] carts_id = (String[]) request.getParameterValues("cart");
		for (String cart_id : carts_id) {
			Long id = Long.parseLong(cart_id);
			Cart cart = cartService.findOne(id);
			cartService.delete(cart.getId());
			// Thêm transaction
			Transaction trans = new Transaction();
//			LineItem line = new LineItem();
//			line.setCart(cart);
//			line.setProduct(cart.getLineItem().getProduct());
//			line.setQuantity(cart.getLineItem().getQuantity());
//			line.setSubtotal(cart.getLineItem().getSubtotal());
//			lineService.create(Optional.ofNullable(line));
			trans.setLineItem(cart.getLineItem());
			trans.setBill(bill);
			transService.create(Optional.ofNullable(trans));
			// Xóa cart
		}
		

		
		return "web/views/thank";
	}
}

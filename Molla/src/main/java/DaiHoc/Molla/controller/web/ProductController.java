package DaiHoc.Molla.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.service.ICategoryService;
import DaiHoc.Molla.service.IManufacturerService;
import DaiHoc.Molla.service.IProductService;

@Controller
@RequestMapping("/")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService cateService;
	@Autowired
	private IManufacturerService manuService;

	@SuppressWarnings("unchecked")
	@GetMapping("product")
	public String getProduct(@RequestParam(defaultValue = "0") int sortby, @RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "0") String cate_id, @RequestParam(defaultValue = "0") String manu_id,
			@RequestParam(defaultValue = "0") String price, ModelMap model) {
		// Handle header
		model.addAttribute("urlPage", "product");

		// Đặt giá trị ban đầu cho filter với price
		if (price.equals("0")) {
			price = "0.0," + productService.findMaxPrice().toString();
		}

		// Find product bằng filter
		List<Product> products = (List<Product>) productService
				.findAll(cate_id, manu_id, Float.parseFloat(price.replace('đ', ' ').split(",")[0].trim()),
						Float.parseFloat(price.replace('đ', ' ').split(",")[1].trim()))
				.get();

		// Get product của page hiện tại
		List<Product> productPage = (List<Product>) productService.findPage(products, sortby, page - 1).get();

		// Handle page number
		if (page < 1)
			page = 1;
		else if (page > productService.calculatePage(products))
			page = productService.calculatePage(products);

		model.addAttribute("products", productPage);
		model.addAttribute("sortby", sortby); // Phương thức sort user chọn
		model.addAttribute("page", page); // Số trang
		model.addAttribute("countPage", productService.calculatePage(products)); // Tổng số trang để xử lí prev/next
		model.addAttribute("categories", cateService.findAll());
		model.addAttribute("manufacturers", manuService.findAll());
		model.addAttribute("cate_id", cate_id); // Để xử lí checked các cate đã chọn trong filter
		model.addAttribute("manu_id", manu_id); // Để xử lí checked các manu đã chọn trong filter
		return "web/views/products";

	}

}

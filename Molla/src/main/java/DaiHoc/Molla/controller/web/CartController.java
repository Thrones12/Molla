package DaiHoc.Molla.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.service.ICartService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class CartController {
	@Autowired
	private ICartService cartService;

	@GetMapping("cart")
	public String getCart(HttpServletRequest request, ModelMap model) {
		Long user_id = Long.parseLong(getCookieValue(request, "user_id"));
		model.addAttribute("carts", cartService.findByUser(user_id).get());
		return "web/views/cart";
	}

	@GetMapping("cart-quantity")
	public String getCartQuantity(@RequestParam Long cart_id, @RequestParam int quantity, ModelMap model) {
		cartService.update(cartService.findOne(cart_id));
		return "redirect:cart";
	}
	
	public String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}

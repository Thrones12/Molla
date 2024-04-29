package DaiHoc.Molla.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CheckOutController {
	@GetMapping("checkout")
	public String getCheckout() {
		return "web/views/checkout";
	}
	@PostMapping("checkout")
	public String postCheckout() {
		return "web/views/thank";
	}
}

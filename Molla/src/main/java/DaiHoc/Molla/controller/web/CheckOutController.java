package DaiHoc.Molla.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CheckOutController {
	@GetMapping("checkout")
	public String getDetail() {
		//${review.user.fullname}
		return "web/views/checkout";
	}
}

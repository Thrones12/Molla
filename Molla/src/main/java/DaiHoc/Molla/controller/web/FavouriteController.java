package DaiHoc.Molla.controller.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.entity.Review;

@Controller
@RequestMapping("/")
public class FavouriteController {
	@GetMapping("favourite")
	public String getDetail() {
		//${review.user.fullname}
		return "web/views/favourite";
	}
}

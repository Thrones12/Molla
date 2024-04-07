package DaiHoc.Molla.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class HomeController {
	@GetMapping("")
    public String getHome() {
        return "web/views/home";
    }
}

package DaiHoc.Molla.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	@RequestMapping({"/home", "/"})
    public String getHome() {
        return "web/views/home";
    }
}

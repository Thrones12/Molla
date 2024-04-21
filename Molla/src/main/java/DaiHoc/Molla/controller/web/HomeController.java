package DaiHoc.Molla.controller.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	UserDetailsService userDetailsService;
	
	@GetMapping("")
	public String getHomePage(Model model, Principal principal) {
		//đoạn này để load tên lên trang homepage
	    if (principal != null) {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
	        model.addAttribute("account", userDetails);
	    }
	    return "web/views/home";
	}

}

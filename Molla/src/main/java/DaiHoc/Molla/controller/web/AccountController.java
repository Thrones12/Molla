package DaiHoc.Molla.controller.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.service.IAccountService;
import DaiHoc.Molla.service.Imp.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	private IAccountService accountService;
	
	@GetMapping({"/register"})
	public String getLoginRegisterPage(@ModelAttribute("account") Account account) {
		return "web/views/customer/register";
	}
	@PostMapping("/register")
	public String saveAccount(@ModelAttribute("account") Account account, Model model) {
		accountService.save(account);
		model.addAttribute("registermessage", "Registered Successfully!");
	    return "web/views/customer/register";
	}
	@GetMapping("/login")
	public String login() {
		return "web/views/customer/login";
	}
	
//	//Đoạn này trong adminController á, có gì copy nội dung cái này qua bên kia nha
//	//t ko có code bên controller, nên tạo để xử lí
//	@GetMapping("/admin")
//    public String getAdminPage(Model model, Principal principal) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("account", userDetails);
//        return "admin/admin";
//    }
}

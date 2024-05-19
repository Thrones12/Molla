package DaiHoc.Molla.controller.web;

import java.security.Principal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import DaiHoc.Molla.config.SecurityConfig;
import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.entity.Bill;
import DaiHoc.Molla.entity.Transaction;
import DaiHoc.Molla.entity.User;
import DaiHoc.Molla.repository.TransactionRepository;
import DaiHoc.Molla.service.Imp.AccountService;
import DaiHoc.Molla.service.Imp.BillService;
import DaiHoc.Molla.service.Imp.UserService;

@Controller
@RequestMapping("/web")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BillService billService;
	@Autowired
	private AccountService accService;
	@Autowired
	private TransactionRepository transRepo;
	@Autowired
	UserDetailsService userDetailsService;
	@GetMapping("/customer")
	public String InformationUserPage(Model model, Principal principal ) {
		Long id = 1L;	
		if (principal != null) {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
	        model.addAttribute("account", userDetails);
	        Account acc = accService.findByUsername(userDetails.getUsername());	 
	        if(acc.getUser() !=null) {
	        	User u = userService.findById(acc.getUser().getId());
		        	model.addAttribute("user", u);
		        	
		        	if(u.getBills() != null) {
		        		List<Bill> list = billService.findBillByUserId(u.getId());				        
				        	model.addAttribute("list", list);
		        	}
				    else {
				        	model.addAttribute("list", null);
				        }	 		        			               
	        }
	        
	        else {
		        model.addAttribute("user", null);	
	        }			 
	    }		
		

		return "/web/views/customer/Infor";
	}
	
	@PostMapping("/update-infor")
	public String updateInfor(@ModelAttribute("user") User user){
		if(userService.editProfile(user)) {
			return "redirect:/web/customer";
		}
		
		return "redirect:/web/update-infor";
	}
	@GetMapping("/bill-detail/{id}")
	public String billDetail(Model model, @PathVariable("id") Long id) {
		
		Bill bill = billService.findById(id);
		List<Transaction> listtrans = transRepo.findTransactionByBillId(id);
		model.addAttribute("listtrans", listtrans);
		model.addAttribute("bill", bill);
		
		return "/web/views/customer/billDetailCus";
	}
	
}

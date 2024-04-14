package DaiHoc.Molla.controller.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.service.IAccountService;

@RestController
@RequestMapping("/api")
public class AccountAPIController {
	@Autowired
	private IAccountService service;
	@GetMapping("/account")
	public ResponseEntity<?> getAccount() {
		List<Account> lists = (List<Account>) service.getAll().get();
		
		return ResponseEntity.ok(lists);
	}
	
	@PostMapping("/account")
	public ResponseEntity<?> postAccount(@RequestBody Account account) {
		try {
			service.create(Optional.of(account));
			return ResponseEntity.ok("OK");
		}
		catch(Exception e) {
			System.out.println("asd");
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
	} 
	
}

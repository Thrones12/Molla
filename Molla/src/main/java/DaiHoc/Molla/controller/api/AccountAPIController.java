package DaiHoc.Molla.controller.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.entity.Transaction;
import DaiHoc.Molla.service.ICartService;
import DaiHoc.Molla.service.ITransactionService;

@RestController
@RequestMapping("/api")
public class AccountAPIController {
	@Autowired
	private ICartService service;
	@Autowired
	private ITransactionService tservice;
	@DeleteMapping("/cart")
	public ResponseEntity<?> getAccount() {
		Transaction t = (Transaction) tservice.getOne(2L).get();
		Transaction newt = new Transaction();
		newt.setBill(t.getBill());
		newt.setLineItem(t.getLineItem());
		tservice.create(Optional.ofNullable(newt));
		service.delete(2L);
		return ResponseEntity.ok("ok");
	}
	
	@PostMapping("/account")
	public ResponseEntity<?> postAccount(@RequestBody Account account) {
		try {
			return ResponseEntity.ok("OK");
		}
		catch(Exception e) {
			System.out.println("asd");
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}
	} 
	
}

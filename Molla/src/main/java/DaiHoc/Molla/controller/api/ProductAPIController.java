package DaiHoc.Molla.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DaiHoc.Molla.service.IProductService;
import DaiHoc.Molla.service.IReviewService;

@RestController
@RequestMapping("/api/product")
public class ProductAPIController {
	@Autowired
	private IProductService service;
	@Autowired
	private IReviewService service1;
	@GetMapping("")
	public ResponseEntity<?> getProduct(){
		
		return ResponseEntity.ok(service.getAll().get());
	}
}

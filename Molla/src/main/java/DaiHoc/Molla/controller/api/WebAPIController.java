package DaiHoc.Molla.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.service.IProductService;

@RestController
@RequestMapping("/api")
public class WebAPIController {
	@Autowired
	private IProductService service;
	@GetMapping("/product")
	public ResponseEntity<?> getProduct() {
		List<Product> products = service.getAll();
		return ResponseEntity.ok(products);
	}
}

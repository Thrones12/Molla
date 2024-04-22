package DaiHoc.Molla.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.entity.User;
import DaiHoc.Molla.repository.CategoryRepository;
import DaiHoc.Molla.service.IAccountService;
import DaiHoc.Molla.service.IBillService;
import DaiHoc.Molla.service.ICategoryService;
import DaiHoc.Molla.service.IManufacturerService;
import DaiHoc.Molla.service.IProductService;
import DaiHoc.Molla.service.IUserService;

@RestController
@RequestMapping("/api")
public class WebAPIController {
	@Autowired
	private CategoryRepository repo;
	@Autowired
	private IProductService proSer;
	@Autowired
	private ICategoryService cateSer;
	@Autowired
	private IManufacturerService manuSer;
	@Autowired
	private IUserService userSer;
	@Autowired
	private IAccountService accountSer;
	

	@GetMapping("/product")
	public ResponseEntity<?> getProduct() {
		List<Product> products = proSer.getAll();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/category")
	public ResponseEntity<?> getCategory() {
		List<Category> categories = cateSer.getAll();
		return ResponseEntity.ok(categories);
	}

	@GetMapping("/manufacturer")
	public ResponseEntity<?> getManufacturer() {
		List<Manufacturer> manufacturies = manuSer.getAll();
		return ResponseEntity.ok(manufacturies);
	}

	@GetMapping("/user")
	public ResponseEntity<?> getUser() {
		List<User> users = userSer.getAll();
		return ResponseEntity.ok(users);
	}

	@GetMapping("/account")
	public ResponseEntity<?> getAccount() {
		List<Account> accounts = accountSer.getAll();
		return ResponseEntity.ok(accounts);
	}
}

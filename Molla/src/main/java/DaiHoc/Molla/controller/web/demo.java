//package DaiHoc.Molla.controller.web;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import DaiHoc.Molla.entity.Category;
//import DaiHoc.Molla.entity.Product;
//import DaiHoc.Molla.service.Imp.CategoryService;
//
//@RequestMapping("/admin")
//@RestController
//
//public class demo {
//	@Autowired
//	private CategoryService categoryService;
//	@GetMapping("/category")
//	 public String index ( ) {
//		Set<Product> list = new HashSet<>();
//
//		Category c = new Category(2l,"samsung","aaaa",list);
//				
//		categoryService.save(c);
//		
//		return "";
//		 
//	 }
//	
//	
//}

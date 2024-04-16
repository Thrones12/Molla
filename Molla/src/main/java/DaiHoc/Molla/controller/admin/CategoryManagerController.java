package DaiHoc.Molla.controller.admin;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.repository.CategoryRepository;
import DaiHoc.Molla.service.Imp.CategoryService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/admin")
public class CategoryManagerController {
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/category")
	public String CategoryMangerPage(Model model) {
		
//		Set<Product> lists = new HashSet<>();
////
//		Category c = new Category(4l,"xiaomi","aaaa",lists);
//		categoryService.save(c);
		List<Category> list = categoryService.getAll();
		model.addAttribute("list", list);
		return "/admin/category/CategoryManager";
	}
	
	
	@GetMapping("/create-category")
	public String addCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "/admin/category/CreateCategory";
	}
	
	
	@PostMapping("/create-category")
	public String createCategory(@ModelAttribute("category") Category category ) {
		if(categoryService.save(category)) {
			return "redirect:/admin/category";
		}
		
		return "redirect:/admin/create-category";
	}
	
	@GetMapping("/update-category/{id}")
	public String editCategory(Model model, @PathVariable("id") Long id) {
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		return "admin/category/UpdateCategory";		
	}
	
	@PostMapping("/update-catrgory")
	public String updateCategory(@ModelAttribute("category") Category category) {
		if(categoryService.save(category)) {
			return "redirect:/admin/category";
		}
		
		return "redirect:/admin/update-catrgory";
	}
	
	@GetMapping("/delete-category/{id}")
	public String deleteCategory(@ModelAttribute("id") Long id) {
		if(categoryService.delete(id)) {
			return "redirect:/admin/category";
		}
		
		return "redirect:/admin/admin";
	}
}
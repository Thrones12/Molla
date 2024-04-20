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
import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.repository.CategoryRepository;
import DaiHoc.Molla.service.IStorageService;
import DaiHoc.Molla.service.Imp.CategoryService;
import DaiHoc.Molla.service.Imp.FileSystemStorageService;
import DaiHoc.Molla.service.Imp.ManufacturerService;
import DaiHoc.Molla.service.Imp.ProductService;
import DaiHoc.Molla.repository.ManufacturerRepository;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class ProductManagerController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ManufacturerService manufacturerService;
	@Autowired
	private ProductService productService;
	@Autowired
	private IStorageService iStorageService;

	@GetMapping("/product")
	public String CategoryMangerPage(Model model) {
		List<Product> list = this.productService.getAll();

		model.addAttribute("list", list);
		return "/admin/views/product/ProductManager";
	}

	@GetMapping("/create-product")
	public String createProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		List<Category> listCate = this.categoryService.getAll();

		model.addAttribute("listCate", listCate);
		List<Manufacturer> listManu = this.manufacturerService.getAll();
		model.addAttribute("listManu", listManu);
		return "/admin/views/product/CreateProduct";
	}

	@PostMapping("/create-product")
	public String createCategory(@ModelAttribute("product") Product product,
			@RequestParam("FilePicture") MultipartFile file) {
		iStorageService.store(file);

		String filename = file.getOriginalFilename();
		product.setPicture(filename);
		if (productService.create(product)) {
			return "redirect:/admin/product";
		}

		return "redirect:/admin/create-product";
	}

//	
	@GetMapping("/update-product/{id}")
	public String editProduct(Model model, @PathVariable("id") Long id) {
		List<Category> listCate = this.categoryService.getAll();

		model.addAttribute("listCate", listCate);
		List<Manufacturer> listManu = this.manufacturerService.getAll();
		model.addAttribute("listManu", listManu);
		
		Product product = productService.getByID(id);
		model.addAttribute("product", product);
		return "admin/views/product/UpdateProduct";
	}

//	
	@PostMapping("/update-product")
	public String updateCategory(@ModelAttribute("product") Product product,
			@RequestParam("FilePicture") MultipartFile file)  {
		if(!file.isEmpty()) {
			iStorageService.store(file);
			String filename = file.getOriginalFilename();
			product.setPicture(filename);
		}
		
		if (productService.update(product)) {
			return "redirect:/admin/product";
		}

		return "redirect:/admin/update-product";
	}

	@GetMapping("/delete-product/{productId}")
	public String deleteProduct(@ModelAttribute("productId") Long id) {
		if (productService.delete(id)) {
			return "redirect:/admin/product";
		}

		return "redirect:/admin/admin";
	}
}
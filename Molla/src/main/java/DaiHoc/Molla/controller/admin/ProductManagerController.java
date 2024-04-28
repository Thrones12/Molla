package DaiHoc.Molla.controller.admin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
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
import DaiHoc.Molla.entity.PromotionalEvent;
import DaiHoc.Molla.repository.CategoryRepository;
import DaiHoc.Molla.service.IStorageService;
import DaiHoc.Molla.service.Imp.CategoryService;
import DaiHoc.Molla.service.Imp.FileSystemStorageService;
import DaiHoc.Molla.service.Imp.ManufacturerService;
import DaiHoc.Molla.service.Imp.ProductService;
import DaiHoc.Molla.service.Imp.PromotionalEventService;
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
	@Autowired
	private PromotionalEventService promotionalEventService;

	@GetMapping("/product")
	public String ProductMangerPage(Model model, @Param("keyword") String keyword, @Param("cateid") Long cateid,
			@Param("manuid") Long manuid,@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo) {
		
		List<Category> listCate = this.categoryService.getAll();	
		model.addAttribute("listCate", listCate);
		
		List<Manufacturer> listManu = this.manufacturerService.getAll();
		model.addAttribute("listManu", listManu);

		Page<Product> list = productService.getAll(pageNo);

		if (keyword != null) {
			list = productService.searchProduct(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
		if(manuid != null && cateid != null) {
			if(manuid == 0 && cateid == 0) {
				 list = productService.getAll(pageNo);
			}
			else if(manuid != 0 && cateid != 0) {
				Manufacturer manu = manufacturerService.findById(manuid);
				
				Category cate = categoryService.findById(cateid);
				model.addAttribute("manuid", manuid);
				model.addAttribute("cateid", cateid);
				
				list = productService.getAllByCategoryAndManufacturer(cate, manu, pageNo);
			}
			else if (manuid == 0) {
				Category cate = categoryService.findById(cateid);
				model.addAttribute("cate", cate);
				list = productService.getAllByCategory(cate, pageNo);
				model.addAttribute("manuid", manuid);
				model.addAttribute("cateid", cateid);
			}
			
			else if (cateid == 0 ) {
				Manufacturer manu = manufacturerService.findById(manuid);
				list = productService.getAllByManufacturer(manu, pageNo);
				model.addAttribute("manuid", manuid);
				model.addAttribute("cateid", cateid);
			}
		}
		
		model.addAttribute("list", list);
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("curPage", pageNo);
		

		return "/admin/views/product/ProductManager";
	}
	@GetMapping("/test")
	public String getProductbyId(Model model, @Param("keyword") String keyword, @Param("cateid") Long cateid,
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo)
	{	
		List<Category> listCate = this.categoryService.getAll();	
		model.addAttribute("listCate", listCate);

		List<Manufacturer> listManu = this.manufacturerService.getAll();
		model.addAttribute("listManu", listManu);
		
		Page<Product> list = productService.getAll(pageNo);
		
		if (keyword != null) {
			list = productService.searchProduct(keyword, pageNo);
			model.addAttribute("keyword", keyword);
		}
	
		if(cateid != null) {
			Category cate = categoryService.findById(cateid);
			
			list = productService.getAllByCategory(cate, pageNo);
		}

	
		model.addAttribute("list", list);
		model.addAttribute("totalPage", list.getTotalPages());
		model.addAttribute("curPage", pageNo);
		return "admin/views/product/test";
	}

	@GetMapping("/create-product")
	public String createProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		List<Category> listCate = this.categoryService.getAll();
		model.addAttribute("listCate", listCate);
		List<PromotionalEvent> pro_event = promotionalEventService.getAll();
		model.addAttribute("pro_event", pro_event);
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
		List<PromotionalEvent> pro_event = promotionalEventService.getAll();
		model.addAttribute("pro_event", pro_event);
		Product product = productService.getByID(id);
		model.addAttribute("product", product);

		return "admin/views/product/UpdateProduct";
	}

//	
	@PostMapping("/update-product")
	public String updateCategory(@ModelAttribute("product") Product product,
			@RequestParam("FilePicture") MultipartFile file) {
		if (!file.isEmpty()) {
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

//	@GetMapping("/filter-by-cate")
////	public String FilterCate(Model model, @Param("id") Long id) {
////
////		List<Category> listCate = this.categoryService.getAll();
////		Category cate = categoryService.findById(id);
////		model.addAttribute("cate", cate);
////
////		Manufacturer manu = manufacturerService.findById(id);
////		model.addAttribute("manu", manu);
////
////		model.addAttribute("listCate", listCate);
////		List<Manufacturer> listManu = this.manufacturerService.getAll();
////		model.addAttribute("listManu", listManu);
////		List<Product> list = productService.getByCategory(id);
////
////		model.addAttribute("list", list);
////		return "/admin/views/product/ProductManager";
////
////	}
//
//	@GetMapping("/filter-by-manu")
//	public String FilterManu(Model model, @Param("id") Long id) {
//
//		List<Category> listCate = this.categoryService.getAll();
//		Category cate = categoryService.findById(id);
//		model.addAttribute("cate", cate);
//		Manufacturer manu = manufacturerService.findById(id);
//		model.addAttribute("manu", manu);
//		model.addAttribute("listCate", listCate);
//		List<Manufacturer> listManu = this.manufacturerService.getAll();
//		model.addAttribute("listManu", listManu);
//		List<Product> list = productService.getByManufacturer(id);
//		model.addAttribute("list", list);
//
//		return "/admin/views/product/ProductManager";
//
//	}
}
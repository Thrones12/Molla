package DaiHoc.Molla.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.service.ICategoryService;
import DaiHoc.Molla.service.IManufacturerService;
import DaiHoc.Molla.service.IProductService;
import DaiHoc.Molla.service.ISubPictureService;

@Controller
@RequestMapping("/")
public class ProductController {
	@Autowired
	private IProductService productService;
	@Autowired
	private ISubPictureService subPictureService;
	@Autowired
	private ICategoryService cateService;
	@Autowired
	private IManufacturerService manuService;

	@SuppressWarnings("unchecked")
	@GetMapping("product")
	public String getProduct(@RequestParam(defaultValue = "0") int sortby, @RequestParam(defaultValue = "1") int page,
							@RequestParam(defaultValue = "-1") Long cate_id,
							@RequestParam(defaultValue = "-1") Long manu_id,
			ModelMap model) {
		if (page < 1)
			page = 1;
		else if (page > productService.calculatePage())
			page = productService.calculatePage();

		List<Product> products = (List<Product>) productService.getAll(cate_id, manu_id, sortby, page - 1).get();

		model.addAttribute("products", products);
		model.addAttribute("page", page);
		model.addAttribute("countPage", productService.calculatePage());
		model.addAttribute("sortby", sortby);
		model.addAttribute("categories", (List<Category>) cateService.getAll().get());
		model.addAttribute("manufacturies", (List<Manufacturer>) manuService.getAll().get());
		return "web/views/products";
	}

	@GetMapping("detail")
	public String getDetail(@RequestParam Long id, ModelMap model) {
		model.addAttribute("product", productService.getOne(id).get());
		return "web/views/detail";
	}
}

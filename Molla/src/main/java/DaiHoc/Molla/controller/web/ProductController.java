package DaiHoc.Molla.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.service.IProductService;

@Controller
@RequestMapping("/")
public class ProductController {
	@Autowired
	private IProductService service;

	@GetMapping("product")
	public String getProduct(@RequestParam(defaultValue = "0") int sortby, @RequestParam(defaultValue = "1") int page,
			ModelMap model) {
		if (page < 1)
			page = 1;
		else if (page > service.calculatePage())
			page = service.calculatePage();

		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) service.getAll(sortby, page - 1).get();

		model.addAttribute("products", products);
		model.addAttribute("page", page);
		model.addAttribute("countPage", service.calculatePage());
		model.addAttribute("sortby", sortby);
		return "web/views/products";
	}

	@GetMapping("detail")
	public String getDetail(ModelMap model) {

		return "web/views/detail";
	}
}

package DaiHoc.Molla.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import DaiHoc.Molla.Utils.ImageFileFounder;
import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.service.ICategoryService;
import DaiHoc.Molla.service.IManufacturerService;
import DaiHoc.Molla.service.IProductService;
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private IProductService service;
	@Autowired
	private ICategoryService cateService;
	@Autowired
	private IManufacturerService manuService;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value = {"home", "index", ""})
    public String getHome(ModelMap model) {
		model.addAttribute("urlPage", "home");
		
		// Handle banner
		List<String> banners = ImageFileFounder.findImageFiles("src/main/resources/static/assets/images/banners");
		model.addAttribute("banners", banners);
		
		// Handle new product
		model.addAttribute("news", service.findNewProduct().get());
		
		// Handle best seller product
		model.addAttribute("best_sellers", service.findBestSellerProduct().get());
		
		// Handle on sale product
		model.addAttribute("on_sales", service.findOnSaleProduct().get());
		
		// Handle product of category
		model.addAttribute("categories", (List<Category>) cateService.getAll().get());

		// Handle product of manufacturer
		model.addAttribute("manufacturers", (List<Manufacturer>) manuService.getAll().get());
        return "web/views/home";
    }
}

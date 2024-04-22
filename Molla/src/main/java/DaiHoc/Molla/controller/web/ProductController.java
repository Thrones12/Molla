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
import DaiHoc.Molla.entity.Review;
import DaiHoc.Molla.service.ICategoryService;
import DaiHoc.Molla.service.IManufacturerService;
import DaiHoc.Molla.service.IProductService;
import DaiHoc.Molla.service.IReviewService;
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
	@Autowired
	private IReviewService reviewService;

	@SuppressWarnings("unchecked")
	@GetMapping("product")
	public String getProduct(@RequestParam(defaultValue = "0") int sortby, @RequestParam(defaultValue = "1") int page,
							@RequestParam(defaultValue = "0") String cate_id,
							@RequestParam(defaultValue = "0") String manu_id,
							@RequestParam(defaultValue = "0") String price,
							ModelMap model) {
		
		model.addAttribute("urlPage", "product");
		
		if (page < 1)
			page = 1;
		else if (page > productService.calculatePage())
			page = productService.calculatePage();
		
		if (price.equals("0")) {
			price = "0.0," + productService.findMaxPrice().toString();
		}
		
		List<Product> products = (List<Product>) productService.findAll(cate_id, manu_id, 
				Float.parseFloat(price.replace('đ', ' ').split(",")[0].trim()), 
				Float.parseFloat(price.replace('đ', ' ').split(",")[1].trim()), 
				sortby, page - 1).get();

		model.addAttribute("products", products);
		model.addAttribute("sortby", sortby);
		model.addAttribute("pageIndex", page);
		model.addAttribute("countPage", productService.calculatePage());
		model.addAttribute("categories", (List<Category>) cateService.getAll().get());
		model.addAttribute("manufacturers", (List<Manufacturer>) manuService.getAll().get());
		model.addAttribute("cate_id", cate_id);
		model.addAttribute("manu_id", manu_id);
		return "web/views/products";
		
	}

	@SuppressWarnings("unchecked")
	@GetMapping("detail")
	public String getDetail(@RequestParam Long id, ModelMap model) {
		//${review.user.fullname}
		List<Review> reviews = (List<Review>) reviewService.findByProduct_Id(id).get();
		Product product = (Product) productService.findOne(id).get();
		model.addAttribute("product", product);
		model.addAttribute("top4_product", productService.findTop4Product().get());
		model.addAttribute("reviews", reviews);
		model.addAttribute("countReview", reviews.size());
		model.addAttribute("categories", (List<Product>) productService.findByCategory(product.getCategory().getId()).get());
		model.addAttribute("manufacturers", (List<Product>) productService.findByManufacturer(product.getManufacturer().getId()).get());
		return "web/views/detail";
	}
}

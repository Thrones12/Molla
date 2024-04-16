package DaiHoc.Molla.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.service.Imp.ManufacturerService;

@Controller
@RequestMapping("/admin")
public class ManufacturerManagerController {
	@Autowired
	private ManufacturerService manufacturerService;
	@GetMapping("/manufacturer")
	public String ManufacturerMangerPage(Model model) {
		
//		Set<Product> lists = new HashSet<>();
////
//		Category c = new Category(4l,"xiaomi","aaaa",lists);
//		categoryService.save(c);
		List<Manufacturer> list = manufacturerService.getAll();
		model.addAttribute("list", list);
		return "/admin/manufacturer/ManufacturerManager";
	}
	
	
	@GetMapping("/create-manufacturer")
	public String addManufacturer(Model model) {
		Manufacturer manufacturer = new Manufacturer();
		model.addAttribute("manufacturer", manufacturer);
		return "/admin/manufacturer/CreateManufacturer";
	}
	
	
	@PostMapping("/create-manufacturer")
	public String createManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer ) {
		if(manufacturerService.save(manufacturer)) {
			return "redirect:/admin/manufacturer";
		}
		
		return "redirect:/admin/create-manufacturer";
	}
	
	@GetMapping("/update-manufacturer/{id}")
	public String editManufacturer(Model model, @PathVariable("id") Long id) {
		Manufacturer manufacturer = manufacturerService.findById(id);
		model.addAttribute("manufacturer", manufacturer);
		return "admin/manufacturer/UpdateManufacturer";		
	}
	
	@PostMapping("/update-manufacturer")
	public String updateManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
		if(manufacturerService.save(manufacturer)) {
			return "redirect:/admin/manufacturer";
		}
		
		return "redirect:/admin/update-manufacturer";
	}
	
	@GetMapping("/delete-manufacturer/{id}")
	public String deleteManufacturer(@ModelAttribute("id") Long id) {
		if(manufacturerService.delete(id)) {
			return "redirect:/admin/manufacturer";
		}
		
		return "redirect:/admin/admin";
	}
}

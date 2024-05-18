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
		List<Manufacturer> list = manufacturerService.findAll();
		model.addAttribute("list", list);
		return "/admin/views/manufacturer/ManufacturerManager";
	}

	@GetMapping("/create-manufacturer")
	public String addManufacturer(Model model) {
		Manufacturer manufacturer = new Manufacturer();
		model.addAttribute("manufacturer", manufacturer);
		return "/admin/views/manufacturer/CreateManufacturer";
	}

	@PostMapping("/create-manufacturer")
	public String createManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
		if (manufacturerService.create(manufacturer)) {
			return "redirect:/admin/manufacturer";
		}

		return "redirect:/admin/create-manufacturer";
	}

	@GetMapping("/update-manufacturer/{id}")
	public String editManufacturer(Model model, @PathVariable("id") Long id) {
		Manufacturer manufacturer = manufacturerService.findOne(id);
		model.addAttribute("manufacturer", manufacturer);
		return "admin/views/manufacturer/UpdateManufacturer";
	}

	@PostMapping("/update-manufacturer")
	public String updateManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
		if (manufacturerService.update(manufacturer)) {
			return "redirect:/admin/manufacturer";
		}

		return "redirect:/admin/update-manufacturer/" + manufacturer.getId();
	}

	@GetMapping("/delete-manufacturer/{id}")
	public String deleteManufacturer(@ModelAttribute("id") Long id) {
		if (manufacturerService.delete(id)) {
			return "redirect:/admin/manufacturer";
		}

		return "redirect:/admin/admin";
	}
}

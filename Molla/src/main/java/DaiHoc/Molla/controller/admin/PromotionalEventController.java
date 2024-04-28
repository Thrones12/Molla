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

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.PromotionalEvent;
import DaiHoc.Molla.entity.User;
import DaiHoc.Molla.service.Imp.PromotionalEventService;

@Controller
@RequestMapping("/admin")
public class PromotionalEventController {
	@Autowired
	private PromotionalEventService promotionalEventService;
	@GetMapping("promotional-event")
	public String PromotionalEventManager(Model model) {
		List<PromotionalEvent> pro_event = promotionalEventService.getAll();
		model.addAttribute("pro_event", pro_event);
		return  "admin/views/DiscountEvent/PromotionalEventManager";
		
	}
	@GetMapping("/create-promotional-event")
	public String addPromotionalEvent(Model model) {
		PromotionalEvent event = new PromotionalEvent();
		model.addAttribute("event", event);
		return "/admin/views/DiscountEvent/CreateEvent";
	}
	@PostMapping("/create-promotional-event")
	public String createCategory(@ModelAttribute("event") PromotionalEvent event ) {
		if(promotionalEventService.save(event)) {
			return "redirect:/admin/promotional-event";
		}
		
		return "redirect:/admin/create-category";
	}
	@GetMapping("/delete-promotional-event/{id}")
	public String deletePromotionalEvent(@ModelAttribute("id") Long id) {
		if(promotionalEventService.delete(id)) {
			return "redirect:/admin/promotional-event";
		}
		
		return "redirect:/admin/admin";
	}
	@GetMapping("/update-promotional-event/{id}")
	public String editPromotionalEvent(Model model, @PathVariable("id") Long id) {
		PromotionalEvent event = promotionalEventService.findById(id);
		model.addAttribute("event", event);
		return "admin/views/DiscountEvent/UpdateEvent";		
	}
	@PostMapping("/update-promotional-event")
	public String updatePromotionalEvent(@ModelAttribute("event") PromotionalEvent event ) {
		if(promotionalEventService.update(event)) {
			return "redirect:/admin/promotional-event";
		}
		
		return "redirect:/admin/create-category";
	}
}

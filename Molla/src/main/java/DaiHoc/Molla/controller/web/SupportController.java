package DaiHoc.Molla.controller.web;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import DaiHoc.Molla.entity.SupportMessage;
import DaiHoc.Molla.service.ISupportMessageService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class SupportController {
	@Autowired
	private ISupportMessageService service;

	@GetMapping("support")
	public String getSupport(ModelMap model) {
		model.addAttribute("messages", service.findAllByAnswerIsNotNull());
		model.addAttribute("spMessage", new SupportMessage());
		return "web/views/support";
	}

	@PostMapping("support")
	public String postSupport(@ModelAttribute("spMessage") @Valid SupportMessage supportMessage, ModelMap model) {
		try {
			supportMessage.setCreatedDate(Date.valueOf(LocalDate.now()));
			service.create(supportMessage);
			return "redirect:support";
		} catch (Exception e) {
			e.printStackTrace();
			return "web/views/404";
		}
	}
}

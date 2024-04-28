package DaiHoc.Molla.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DaiHoc.Molla.service.IFavouriteService;

@RestController
@RequestMapping("/api/favourite")
public class SubPictureAPIController {
	@Autowired
	private IFavouriteService service;
	@GetMapping("")
	public ResponseEntity<?> getSubpicture(){
		return ResponseEntity.ok(service.findByUser(1L));
	}
}

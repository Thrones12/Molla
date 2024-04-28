package DaiHoc.Molla.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.Utils.CookieManager;
import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Favourite;
import DaiHoc.Molla.service.ICategoryService;
import DaiHoc.Molla.service.IFavouriteService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class FavouriteController {
	@Autowired
	private IFavouriteService service;
	@Autowired
	private ICategoryService cateService;
	@SuppressWarnings("unchecked")
	@GetMapping("favourite")
	public String getDetail(HttpServletRequest request, ModelMap model) {
		try {
			model.addAttribute("categories", (List<Category>) cateService.getAll().get());
			Long user_id = Long.parseLong(CookieManager.getCookieValue(request, "user_id"));
			List<Favourite> favourites = (List<Favourite>) service.findByUser(user_id).get();
			service.setState(favourites);
			model.addAttribute("favourites", favourites);
			return "web/views/favourite";
		}
		catch(Exception e) {
			e.printStackTrace();
			return "web/views/404";
		}
	}
	@DeleteMapping("remove-fav")
	public ResponseEntity<String> deleteCart(HttpServletRequest request, 
			@RequestParam("fav_id") Long fav_id){
		if (service.delete(fav_id)) {
		    String responseScript = 
					"setTimeout(function() {\r\n"
							+ "		Swal.fire({\r\n"
							+ "			icon : 'success',\r\n"
							+ "			title : 'Xóa thành công!',\r\n"
							+ "			showConfirmButton : false,\r\n"
							+ "			timer : 1000\r\n"
							+ "		});\r\n"
							+ "	}, 0); ";
		    return ResponseEntity.ok(responseScript);
		}
		else {
			String responseScript = 
					"setTimeout(function() {\r\n"
							+ "		Swal.fire({\r\n"
							+ "			icon : 'error',\r\n"
							+ "			title : 'Thất bại!',\r\n"
							+ "			showConfirmButton : false,\r\n"
							+ "			timer : 1000\r\n"
							+ "		});\r\n"
							+ "	}, 0); ";
		    return ResponseEntity.ok(responseScript);
		}
	}
}

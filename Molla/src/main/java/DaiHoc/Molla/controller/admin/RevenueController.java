package DaiHoc.Molla.controller.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import DaiHoc.Molla.entity.Bill;
import DaiHoc.Molla.entity.MonthlyRevenue;
import DaiHoc.Molla.service.Imp.BillService;

@Controller
@RequestMapping("/admin")
public class RevenueController {
	@Autowired
	private BillService billService;
	

	@GetMapping("/revenue")
	public String showRevenueChart1(Model model) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date   startDate = dateFormat.parse("2024-01-01");
		Date   endDate = dateFormat.parse("2024-12-31");
		float t2024 = billService.TotalRevenueBetweenDates(startDate, endDate) ;
		model.addAttribute("t2024", t2024);
        List<MonthlyRevenue> monthlyRevenueList = billService.calculateMonthlyRevenue();
        model.addAttribute("monthlyRevenueList", monthlyRevenueList);
        return "/admin/views/revenue/totalrevenue";
    }

}

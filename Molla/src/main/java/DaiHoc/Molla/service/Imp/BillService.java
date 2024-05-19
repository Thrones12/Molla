package DaiHoc.Molla.service.Imp;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Bill;
import DaiHoc.Molla.repository.BillRepository;
import DaiHoc.Molla.service.IBillService;

@Service
public class BillService implements IBillService {
	@Autowired
	private BillRepository repo;

	@Override
	public Bill findOne(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Optional<?> findByUser_id(Long user_id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean create(Optional<?> object) {
		try {
			repo.save((Bill) object.get());
			repo.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Bill createAndReturn(Bill bill) {
		try {
			Bill savedBill = repo.save(bill);
			return savedBill;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(Bill object) {
		try {
			new Bill();
			Bill bill = Bill.builder().user(object.getUser()).product_price(object.getProduct_price())
					.ship(object.getShip()).total_price(object.getTotal_price()).bill_date(object.getBill_date())
					.state(object.getState()).receiver(object.getReceiver())
					.address_shipment(object.getAddress_shipment()).phone_shipment(object.getPhone_shipment())
					.email(object.getEmail()).note(object.getNote()).promotionalCode(object.getPromotionalCode())
					.build();
			repo.save(bill);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Long id) {
		try {
			repo.delete(findOne(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Bill> findBillByUserId(Long userId) {
		// TODO Auto-generated method stub
		return repo.findBillByUserId(userId);
	}

	@Override
	public Map<String, Double> getMonthlyRevenueByYear(int year) {
		List<Bill> paidBills = repo.findByState(1);

		Map<String, Double> monthlyRevenue = new LinkedHashMap<>();

	    // Khởi tạo giá trị mặc định là 0 cho tất cả các tháng
	    for (Month month : Month.values()) {
	        String monthName = month.getDisplayName(TextStyle.FULL, new Locale("vi", "VN")) + " " + year;
	        monthlyRevenue.put(monthName, 0.0);
	    }
	    
		for (Bill bill : paidBills) {
			LocalDate billDate = bill.getBill_date().toLocalDate();
			if (billDate.getYear() == year) {
				String month = billDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("vi", "VN")) + " "
						+ billDate.getYear();
				monthlyRevenue.merge(month, (double) bill.getTotal_price(), Double::sum);
			}
		}

		return monthlyRevenue;
	}

	@Override
	public List<Integer> getAvailableYears() {
		List<Bill> paidBills = repo.findByState(1); // Giả sử eOrderStatus.PAID là một giá trị phù hợp cho trạng thái
													// "PAID"

		return paidBills.stream().map(bill -> bill.getBill_date().toLocalDate().getYear()).distinct().sorted()
				.collect(Collectors.toList());
	}

}

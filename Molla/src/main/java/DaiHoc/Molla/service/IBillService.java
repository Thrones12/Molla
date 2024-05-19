package DaiHoc.Molla.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Bill;

@Component
public interface IBillService {
	Bill findOne(Long id);
	Optional<?> findByUser_id(Long user_id);
	
	boolean create(Optional<?> object);
	Bill createAndReturn(Bill bill);
	boolean update(Bill object);
	boolean delete(Long id);
	List<Bill> findBillByUserId(Long userId);
	Map<String, Double> getMonthlyRevenueByYear(int year);
	List<Integer> getAvailableYears();
}

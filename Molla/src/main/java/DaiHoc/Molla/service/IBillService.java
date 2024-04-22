package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Bill;

@Component
public interface IBillService {

	List<Bill> getAll();
	Boolean save(Bill account);
	Boolean update(Bill account);
	Boolean delete(Long Id);
	Bill findById(Long id);
	List<Bill> findBillByUserId(Long userId);
}

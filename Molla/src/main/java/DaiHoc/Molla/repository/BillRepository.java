package DaiHoc.Molla.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import DaiHoc.Molla.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{
	List<Bill> findBillByUserId(Long userId);

	List<Bill> findByState(int state);
}

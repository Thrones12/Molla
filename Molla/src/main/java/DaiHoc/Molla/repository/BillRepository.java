package DaiHoc.Molla.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	List<Bill> findBillByUserId(Long userId);
	
	@Query("SELECT SUM(o.total_price) FROM Bill o WHERE o.billDate BETWEEN :startDate AND :endDate")
	Float findTotalRevenueBetweenDates(Date startDate, Date endDate);
	
	@Query("SELECT YEAR(b.billDate), MONTH(b.billDate), SUM(b.total_price) FROM Bill b GROUP BY YEAR(b.billDate), MONTH(b.billDate)")
    List<Object[]> getMonthlyRevenue();
    

}



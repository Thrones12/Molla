package DaiHoc.Molla.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.LineItem;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Long> {

////////////////////////////////////////////////////////
//	@Query("SELECT li.product, SUM(li.quantity) as totalQuantity " + "FROM LineItem li " + "JOIN li.bill b "
//			+ "WHERE FUNCTION('MONTH', b.billDate) = :month " + "AND FUNCTION('YEAR', b.billDate) = :year "
//			+ "GROUP BY li.product " + "ORDER BY totalQuantity DESC")
//	List<Object[]> findTopProductsByMonthAndYear(int month, int year, Pageable pageable);
//}
}
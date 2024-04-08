package DaiHoc.Molla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{
}

package DaiHoc.Molla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long>{


}

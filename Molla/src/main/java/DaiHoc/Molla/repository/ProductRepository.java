package DaiHoc.Molla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Procedure(name = "GetProductsByCategoryAndManufacturer")
	List<Product> GetProductsByCategoryAndManufacturer(Long cate_id, Long manu_id);

}

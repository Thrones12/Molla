package DaiHoc.Molla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	
	
	
	List<Product> findByCategory(Category category);
	
	List<Product> findByManufacturer(Manufacturer manu);
	
	List<Product> findProductsByCategoryAndManufacturer(Category category,Manufacturer manu);
	
	@Query("SELECT c FROM Product c WHERE c.name LIKE %?1%")
	List<Product> searchProduct(String keyword);



}

	package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;
@Component
public interface IProductService {
	List<Product> getAll();
	Product getByID(Long id);
	List<Product> findByCategory(Category category);
	List<Product> findByManufacturer(Manufacturer manu);
	List<Product> findProductsByCategoryAndManufacturer(Category category,Manufacturer manu);
	
	
	
	boolean create(Product product);
	boolean update(Product product);
	boolean delete(Long id);
	
	Page<Product> getAllByManufacturer(Manufacturer manu,Integer pageNo);
	Page<Product> getAllByCategory(Category category,Integer pageNo);
	Page<Product> getAllByCategoryAndManufacturer(Category category,Manufacturer manu,Integer pageNo);
	
	List<Product> searchProduct(String keyword);
	Page<Product> getAll(Integer pageNo);
	Page<Product> searchProduct(String keyword, Integer pageNo);
}

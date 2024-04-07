package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Product;
@Component
public interface IProductService {
	List<Product> getAll();
	Product getByID(Long id);
	Product getByCategory(Long cateID);
	Product getByManufacturer(Long manuID);
	
	boolean create(Product product);
	boolean update(Product product);
	boolean delete(Long id);
}

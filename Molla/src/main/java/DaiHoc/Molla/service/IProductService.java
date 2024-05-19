	package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;


@Component
public interface IProductService {
	// Tìm kiếm
	List<Product> findAll();
	Optional<?> findAll(String str_cate, String str_manu, float min_price, float max_price);
	Optional<?> findPage(List<Product> products, int sortby, int page);
	List<Product> findByCategory(Long cateID);
	List<Product> findByManufacturer(Long manuID);
	Product findOne(Long id);
	
	// Tìm kiếm top sản phẩm
	Optional<?> findTop4Product();
	Optional<?> findNewProduct();
	Optional<?> findBestSellerProduct();
	Optional<?> findOnSaleProduct();
	Optional<?> search(String search);
	List<Product> findProductsByCategoryAndManufacturer(Category category,Manufacturer manu);
	
	
	
	// Tác vụ
	boolean create(Product object);
	boolean update(Product object);
	boolean delete(Long id);
	
	// Khác
	int count(Optional<?> products);
	public int calculatePage(List<Product> products);
	Float findMaxPrice();
	
	Page<Product> getAllByManufacturer(Manufacturer manu,Integer pageNo);
	Page<Product> getAllByCategory(Category category,Integer pageNo);
	Page<Product> getAllByCategoryAndManufacturer(Category category,Manufacturer manu,Integer pageNo);
	
	List<Product> searchProduct(String keyword);
	Page<Product> getAll(Integer pageNo);
	Page<Product> searchProduct(String keyword, Integer pageNo);
}

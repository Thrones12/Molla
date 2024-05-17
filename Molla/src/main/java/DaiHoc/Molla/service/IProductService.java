package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Product;


@Component
public interface IProductService {
	// Tìm kiếm
	Optional<?> findAll();
	Optional<?> findAll(String str_cate, String str_manu, float min_price, float max_price);
	Optional<?> findPage(List<Product> products, int sortby, int page);
	Optional<?> findByCategory(Long cateID);
	Optional<?> findByManufacturer(Long manuID);
	Product findOne(Long id);
	
	// Tìm kiếm top sản phẩm
	Optional<?> findTop4Product();
	Optional<?> findNewProduct();
	Optional<?> findBestSellerProduct();
	Optional<?> findOnSaleProduct();
	Optional<?> search(String search);
	
	// Tác vụ
	boolean create(Product object);
	boolean update(Product object);
	boolean delete(Long id);
	
	// Khác
	int count(Optional<?> products);
	public int calculatePage(List<Product> products);
	Float findMaxPrice();
}

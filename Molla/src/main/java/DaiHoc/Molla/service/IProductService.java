package DaiHoc.Molla.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Product;


@Component
public interface IProductService {
	// Tìm kiếm
	Optional<?> findAll();
	Optional<?> findAll(String cate_id, String manu_id, float min_price, float max_price, int sortby, int page);
	Optional<?> findOne(Long id);
	Optional<?> findByCategory(Long cateID);
	Optional<?> findByManufacturer(Long manuID);
	
	// Tìm kiếm top sản phẩm
	Optional<?> findTop4Product();
	Optional<?> findNewProduct();
	Optional<?> findBestSellerProduct();
	Optional<?> findOnSaleProduct();
	
	// Tác vụ
	boolean create(Optional<?> object);
	boolean update(Optional<?> object);
	boolean delete(Long id);
	
	// Khác
	int count(Optional<?> products);
	public int calculatePage();
	Float findMaxPrice();
}

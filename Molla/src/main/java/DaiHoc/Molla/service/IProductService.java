package DaiHoc.Molla.service;

import java.util.Optional;

import org.springframework.stereotype.Component;


@Component
public interface IProductService {
	Optional<?> getAll();
	Optional<?> getAll(int page);
	Optional<?> getAll(String cate_id, String manu_id, float min_price, float max_price, int sortby, int page);
	
	Optional<?> getOne(Long id);
	Optional<?> getByCategory(Long cateID);
	Optional<?> getByManufacturer(Long manuID);
	
	boolean create(Optional<?> object);
	boolean update(Optional<?> object);
	boolean delete(Long id);
	
	int count(Optional<?> products);
	public int calculatePage();
}

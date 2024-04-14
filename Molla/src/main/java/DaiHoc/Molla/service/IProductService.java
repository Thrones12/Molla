package DaiHoc.Molla.service;

import java.util.Optional;

import org.springframework.stereotype.Component;


@Component
public interface IProductService {
	Optional<?> getAll();
	Optional<?> getAll(int page);
	Optional<?> getAll(Long cate_id, Long manu_id, int sortby, int page);
	
	Optional<?> getOne(Long id);
	Optional<?> getByCategory(Long cateID);
	Optional<?> getByManufacturer(Long manuID);
	
	boolean create(Optional<?> object);
	boolean update(Optional<?> object);
	boolean delete(Long id);
	
	int count(Optional<?> products);
	public int calculatePage();
}

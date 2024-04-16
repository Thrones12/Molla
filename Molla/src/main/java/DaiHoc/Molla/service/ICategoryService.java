package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Category;
@Component
public interface ICategoryService {
	List<Category> getAll();
	Boolean save(Category category);
	Boolean update(Category category);
	Boolean delete(Long Id);
	Category findById(Long id);
}

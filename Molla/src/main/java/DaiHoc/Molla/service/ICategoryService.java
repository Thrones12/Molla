package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Category;
@Component
public interface ICategoryService {
	List<Category> getAll();
}

package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.repository.CategoryRepository;
import DaiHoc.Molla.service.ICategoryService;
@Service
public class CategoryService implements ICategoryService
{
	@Autowired
	private CategoryRepository repo;
	@Override
	public List<Category> getAll() {
		return repo.findAll();
	}

}

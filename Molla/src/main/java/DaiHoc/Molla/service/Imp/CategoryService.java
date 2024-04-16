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
	@Override
	public Boolean save(Category category) {
		// TODO Auto-generated method stub
		try {
			repo.save(category);
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}
	@Override
	public Category findById(Long id) {	
		return repo.findById(id).get();
	}
	@Override
	public Boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			repo.save(category);
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}
	@Override
	public Boolean delete(Long Id) {
		try {
			repo.delete(findById(Id));
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}

}

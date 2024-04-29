package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

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
	public Optional<?> getAll() {
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public Optional<?> getOne(Long id) {
		return repo.findById(id);
	}

	@Override
	public boolean create(Optional<?> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Optional<?> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try {
			repo.delete((Category)getOne(id).get());
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}
	

}

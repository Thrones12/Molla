package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.repository.ProductRepository;
import DaiHoc.Molla.service.IProductService;
@Service
public class ProductService implements IProductService{
	@Autowired
	ProductRepository repo;
	
	@Override
	public List<Product> getAll() {
		return repo.findAll();
	}

	@Override
	public Product getByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getByCategory(Long cateID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getByManufacturer(Long manuID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}

package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.repository.ProductRepository;
import DaiHoc.Molla.service.IProductService;
@Service
public class ProductService implements IProductService{
	@Autowired
	private ProductRepository repo;
	
	@Override
	public List<Product> getAll() {
		return repo.findAll();
	}

	@Override
	public Product getByID(Long id) {
		return repo.findById(id).get();
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
		try {
			repo.save(product);
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			Optional<Product> opt = Optional.of(getByID(product.getProductId()));
			if (opt.isPresent()) {
				repo.save(product);
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		try {
			repo.delete(getByID(id));
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}

}

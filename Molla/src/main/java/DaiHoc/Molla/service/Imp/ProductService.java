package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.repository.ProductRepository;
import DaiHoc.Molla.service.IProductService;

@Service
public class ProductService implements IProductService {
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
	public boolean create(Product product) {
		// TODO Auto-generated method stub
		try {
			repo.save(product);
			return true;
		} catch (Exception e) {
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
			} else {
				return false;
			}
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> findByCategory(Category category) {

		return repo.findByCategory(category);
	}

	@Override
	public List<Product> findByManufacturer(Manufacturer manu) {

		return repo.findByManufacturer(manu);
	}

	public List<Product> searchProduct(String keyword) {
		// TODO Auto-generated method stub
		return repo.searchProduct(keyword);
	}

	@Override
	public Page<Product> getAll(Integer pageNo) {
		Pageable pageable = PageRequest.of(pageNo - 1, 4);
		return repo.findAll(pageable);
	}

	@Override
	public Page<Product> searchProduct(String keyword, Integer pageNo) {
		List<Product> list = this.searchProduct(keyword);
		Pageable pageable = PageRequest.of(pageNo - 1, 4);
		Integer start = (int) pageable.getOffset();
		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
				: pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start, end);

		return new PageImpl<Product>(list, pageable, this.searchProduct(keyword).size());
	}

	@Override
	public Page<Product> getAllByCategory(Category category, Integer pageNo) {
		// TODO Auto-generated method stub
		List<Product> list = this.findByCategory(category);
		Pageable pageable = PageRequest.of(pageNo - 1, 4);
		Integer start = (int) pageable.getOffset();

		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
				: pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start, end);

		return new PageImpl<Product>(list, pageable, this.findByCategory(category).size());
	}

	@Override
	public Page<Product> getAllByManufacturer(Manufacturer manu, Integer pageNo) {
		// TODO Auto-generated method stub
		List<Product> list = this.findByManufacturer(manu);
		Pageable pageable = PageRequest.of(pageNo - 1, 4);
		Integer start = (int) pageable.getOffset();

		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
				: pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start, end);

		return new PageImpl<Product>(list, pageable, this.findByManufacturer(manu).size());
	}

	@Override
	public List<Product> findProductsByCategoryAndManufacturer(Category category, Manufacturer manu) {
		// TODO Auto-generated method stub
		return repo.findProductsByCategoryAndManufacturer(category, manu);
	}

	@Override
	public Page<Product> getAllByCategoryAndManufacturer(Category category, Manufacturer manu, Integer pageNo) {
		// TODO Auto-generated method stub
		List<Product> list = this.findProductsByCategoryAndManufacturer(category,manu);
		Pageable pageable = PageRequest.of(pageNo - 1, 4);
		Integer start = (int) pageable.getOffset();

		Integer end = (int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size()
				: pageable.getOffset() + pageable.getPageSize());
		list = list.subList(start, end);

		return new PageImpl<Product>(list, pageable, this.findProductsByCategoryAndManufacturer(category,manu).size());
	}

}

package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.Utils.Constant;
import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.repository.ProductRepository;
import DaiHoc.Molla.service.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired
	ProductRepository repo;

	@Override
	public Optional<?> getAll() {
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public Optional<?> getAll(int page) {
		PageRequest pageable = PageRequest.of(page, Constant.productPerPage, Sort.by("name").ascending());
		return Optional.ofNullable(repo.findAll(pageable).getContent());
	}

	@Override
	public Optional<?> getAll(int sortby, int page) {
		PageRequest pageable = null;
		if (sortby == Constant.eSortby.ASCENDING.ordinal()) {
			pageable = PageRequest.of(page, Constant.productPerPage, Sort.by("name").ascending());
		} else if (sortby == Constant.eSortby.POPULARITY.ordinal()) {
			pageable = PageRequest.of(page, Constant.productPerPage, Sort.by("sold").descending());
		} else if (sortby == Constant.eSortby.RATING.ordinal()) {
			pageable = PageRequest.of(page, Constant.productPerPage, Sort.by("rating").descending());
		} else if (sortby == Constant.eSortby.DATE.ordinal()) {
			pageable = PageRequest.of(page, Constant.productPerPage, Sort.by("id").descending());
		}
		return Optional.ofNullable(repo.findAll(pageable).getContent());
	}

	@Override
	public Optional<?> getByID(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<?> getByCategory(Long cateID) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<?> getByManufacturer(Long manuID) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<?> getOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count(Optional<?> products) {
		@SuppressWarnings("unchecked")
		List<Product> items = (List<Product>) products.get();
		return items.size();
	}

	public int calculatePage() {
		List<Product> products = repo.findAll();
		if (products.size() % Constant.productPerPage != 0) {
			return products.size() / Constant.productPerPage + 1;
		} else {
			return products.size() / Constant.productPerPage;
		}
	}

}

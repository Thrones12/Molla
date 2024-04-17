package DaiHoc.Molla.service.Imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.Utils.Constant;
import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.repository.ProductRepository;
import DaiHoc.Molla.service.IProductService;
import jakarta.transaction.Transactional;

@Service
public class ProductService implements IProductService {
	@Autowired
	ProductRepository repo;

	@Override
	public Optional<?> findAll() {
		return Optional.ofNullable(repo.findAll());
	}

	@SuppressWarnings("unchecked")
	@Override
    @Transactional
	public Optional<?> findAll(String str_cate, String str_manu, float min_price, float max_price, int sortby, int page) {
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
		List<Product> products = repo.findProductsByCategoryAndManufacturer(str_cate, str_manu, min_price, max_price);
	    int start = (int) pageable.getOffset();
	    int end = Math.min((start + pageable.getPageSize()), products.size());
	    Page<Product> productPage = new PageImpl<>(products.subList(start, end), pageable, products.size());
	    
	    return Optional.ofNullable(productPage.getContent());
	}
	
	@Override
    @Transactional
	public Optional<?> findTop4Product() {
		return Optional.ofNullable(repo.findTop4Product());
	}

	@Override
	public Optional<?> findByCategory(Long cateID) {
		return Optional.ofNullable(repo.findByCategory_Id(cateID));
	}

	@Override
	public Optional<?> findByManufacturer(Long manuID) {
		return Optional.ofNullable(repo.findByManufacturer_Id(manuID));
	}
	
	@Override
	public Float findMaxPrice() {
		return repo.findMaxPrice();
	}

	@Override
	public Optional<?> findOne(Long id) {
		return Optional.ofNullable(repo.findById(id));
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

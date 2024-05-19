package DaiHoc.Molla.service.Imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

	// Tìm kiếm
	@Override
	public Optional<?> findAll() {
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	@Transactional
	public Optional<?> findPage(List<Product> products, int sortby, int page) {
		// Xác định các tùy chọn phân trang
	    PageRequest pageable = PageRequest.of(page, Constant.productPerPage);

	    // Sắp xếp danh sách products dựa trên sortby
	    if (sortby == Constant.eSortby.ASCENDING.ordinal()) {
	        products.sort(Comparator.comparing(Product::getName));
	    } else if (sortby == Constant.eSortby.POPULARITY.ordinal()) {
	        products.sort(Comparator.comparing(Product::getSold).reversed());
	    } else if (sortby == Constant.eSortby.RATING.ordinal()) {
	        products.sort(Comparator.comparing(Product::getRating).reversed());
	    } else if (sortby == Constant.eSortby.DATE.ordinal()) {
	        products.sort(Comparator.comparing(Product::getId).reversed());
	    }

	    // Tính toán phân trang
	    int start = (int) pageable.getOffset();
	    int end = Math.min((start + pageable.getPageSize()), products.size());

	    // Tạo đối tượng Page<Product>
	    Page<Product> productPage = new PageImpl<>(products.subList(start, end), pageable, products.size());

	    return Optional.ofNullable(productPage.getContent());
	}

	@Override
	@Transactional
	public Optional<?> findAll(String str_cate, String str_manu, float min_price, float max_price) {
		return Optional
				.ofNullable(repo.findProductsByCategoryAndManufacturer(str_cate, str_manu, min_price, max_price));
	}

	@Override
	@Transactional
	public Optional<?> findTop4Product() {
		return Optional.ofNullable(repo.findTop4Product());
	}

	@Override
	public Optional<?> findByCategory(Long cateID) {
		System.out.println(cateID);
		return Optional.ofNullable(repo.findByCategory_Id(cateID));
	}

	@Override
	public Optional<?> findByManufacturer(Long manuID) {
		return Optional.ofNullable(repo.findByManufacturer_Id(manuID));
	}

	@Override
	@Transactional
	public Optional<?> findNewProduct() {
		return Optional.ofNullable(repo.findNewProduct());
	}

	@Override
	@Transactional
	public Optional<?> findBestSellerProduct() {
		return Optional.ofNullable(repo.findBestSellerProduct());
	}

	@Override
	@Transactional
	public Optional<?> findOnSaleProduct() {
		return Optional.ofNullable(repo.findOnSaleProduct());
	}

	@Override
	public Float findMaxPrice() {
		return repo.findMaxPrice();
	}

	@Override
	public Product findOne(Long id) {
		return repo.findById(id).get();
	}

	@Override
	@Transactional
	public Optional<?> search(String search) {
		return Optional.ofNullable(repo.search(search));
	}

	// Tác vụ
	@Override
	public boolean create(Product object) {
		try {
			repo.save(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product object) {
		try {
			repo.save(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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

	public int calculatePage(List<Product> products) {
		if (products.size() % Constant.productPerPage != 0) {
			return products.size() / Constant.productPerPage + 1;
		} else {
			return products.size() / Constant.productPerPage;
		}
	}

}

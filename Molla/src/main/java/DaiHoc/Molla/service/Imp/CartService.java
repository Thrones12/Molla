package DaiHoc.Molla.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Cart;
import DaiHoc.Molla.entity.LineItem;
import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.entity.User;
import DaiHoc.Molla.repository.CartRepository;
import DaiHoc.Molla.repository.LineItemRepository;
import DaiHoc.Molla.repository.ProductRepository;
import DaiHoc.Molla.repository.UserRepository;
import DaiHoc.Molla.service.ICartService;
@Service
public class CartService implements ICartService
{
	@Autowired
	private CartRepository repo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ProductRepository proRepo;
	@Autowired
	private LineItemRepository lineRepo;

	@Override
	public Optional<?> findAll() {
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public Optional<?> findByUser(Long user_id) {
		return Optional.ofNullable(repo.findByUser_Id(user_id));
	}
	
	@Override
	public Cart findOne(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public boolean create(Long user_id, Long pro_id, int quantity) {
		try {
			User user = userRepo.findById(user_id).get();
			Product pro = proRepo.findById(pro_id).get();
			LineItem line = new LineItem();
			line.setProduct(pro);
			line.setQuantity(quantity);
			line.setSubtotal(quantity*pro.getSelling_price());
			lineRepo.save(line);
			Cart cart = new Cart();
			cart.setUser(user);
			cart.setLineItem(line);
			repo.save(cart);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Cart cart) {
		repo.save(cart);
		return true;
	}

	@Override
	public boolean delete(Long id) {
		try {
			Cart cart = findOne(id);
			repo.delete(cart);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean deleteWithLineItem(Long id) {
		try {
			Cart cart = findOne(id);
			repo.delete(cart);
			lineRepo.delete(cart.getLineItem());
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean isCartPresent(Long user_id, Long pro_id) {
		User user = userRepo.findById(user_id).get();
		for (Cart c : user.getCarts()) {
			if (c.getLineItem().getProduct().getId() == pro_id)
				return true;
		}
		return false;
	}

	@Override
	public boolean changeQuantity(Long cart_id, int quantity) {
		try {
			Cart cart = findOne(cart_id);
			cart.getLineItem().setQuantity(quantity);
			repo.flush();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


}

package DaiHoc.Molla.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Cart;
import DaiHoc.Molla.repository.CartRepository;
import DaiHoc.Molla.service.ICartService;
@Service
public class CartService implements ICartService
{
	@Autowired
	private CartRepository repo;

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
	public boolean create(Optional<?> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Cart cart) {
		repo.save(cart);
		return true;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}


}

package DaiHoc.Molla.service.Imp;

import java.util.List;

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
	public List<Cart> getAll() {
		return repo.findAll();
	}

}

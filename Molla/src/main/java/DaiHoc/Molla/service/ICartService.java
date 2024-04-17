package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Cart;


@Component
public interface ICartService {
	Optional<?> findAll();
	Optional<?> findByUser(Long user_id);
	Cart findOne(Long id);
	boolean create(Optional<?> object);
	boolean update(Cart cart);
	boolean delete(Long id);
}

package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Cart;

@Component
public interface ICartService {
	List<Cart> getAll();
}

package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;


@Component
public interface IAccountService {
	Optional<?> getAll();
	Optional<?> getOne(String username, String password);
	boolean create(Optional<?> object);
	boolean update(Optional<?> object);
	boolean delete(Long id);
}
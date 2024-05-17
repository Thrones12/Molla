package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.User;


@Component
public interface IUserService {
	List<User> findAll();
	User findOne(Long id);
	boolean create(Optional<?> object);
	boolean update(Optional<?> object);
	boolean delete(Long id);
}

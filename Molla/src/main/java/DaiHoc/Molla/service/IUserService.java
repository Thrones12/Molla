package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.User;

@Component
public interface IUserService {
	List<User> getAll();

	Boolean save(User user);
	Boolean update(User user);
	Boolean delete(Long Id);
	User findById(Long id);
}

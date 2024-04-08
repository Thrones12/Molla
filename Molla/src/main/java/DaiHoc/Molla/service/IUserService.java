package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.User;

@Component
public interface IUserService {
	List<User> getAll();
}

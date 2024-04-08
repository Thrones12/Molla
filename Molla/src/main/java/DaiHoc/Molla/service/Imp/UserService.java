package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.User;
import DaiHoc.Molla.repository.UserRepository;
import DaiHoc.Molla.service.IUserService;
@Service
public class UserService implements IUserService
{
	@Autowired
	private UserRepository repo;
	@Override
	public List<User> getAll() {
		return repo.findAll();
	}

}

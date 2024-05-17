package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

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
	public List<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User findOne(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public boolean create(Optional<?> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Optional<?> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}

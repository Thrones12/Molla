package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.entity.Category;
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
	@Override
	public Boolean save(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean update(User user) {
		try {
			Optional<User> opt = Optional.of(findById(user.getId()));
			if (opt.isPresent()) {
				repo.save(user);
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Boolean delete(Long Id) {
		try {
			repo.delete(findById(Id));
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}
	@Override
	public User findById(Long id) {	
		return repo.findById(id).get();
	}

}

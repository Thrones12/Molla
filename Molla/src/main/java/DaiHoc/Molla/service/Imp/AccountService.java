package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.repository.AccountRepository;
import DaiHoc.Molla.service.IAccountService;
@Service
public class AccountService implements IAccountService
{
	@Autowired
	private AccountRepository repo;
	@Override
	public Optional<?> getAll() {
		return Optional.ofNullable(repo.findAll());
	}
	@Override
	public Optional<?> getOne(String username, String password) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public boolean create(Optional<?> object) {
		repo.save((Account) object.get());
		return true;
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

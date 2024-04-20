package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.repository.AccountRepository;
import DaiHoc.Molla.service.IAccountService;
@Service
public class AccountService implements IAccountService
{
	@Autowired
	private AccountRepository repo;
	@Override
	public List<Account> getAll() {
		return repo.findAll();
	}
	@Override
	public Boolean save(Account account) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean update(Account acc) {
		try {
			Optional<Account> opt = Optional.of(findById(acc.getId()));
			if (opt.isPresent()) {
				repo.save(acc);
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account findById(Long id) {

		return  repo.findById(id).get();
	}
	@Override
	public Account findAccountByUserId(Long id) {
		// TODO Auto-generated method stub
		return repo.findAccountByUserId(id);
	}



}

package DaiHoc.Molla.service.Imp;

import java.util.List;

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
	public List<Account> getAll() {
		return repo.findAll();
	}

}

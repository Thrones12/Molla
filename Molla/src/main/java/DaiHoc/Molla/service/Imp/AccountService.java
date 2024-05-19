package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.Utils.Constant;
import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.repository.AccountRepository;
import DaiHoc.Molla.service.IAccountService;
@Service
public class AccountService implements IAccountService
{
	@Autowired
	private AccountRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Account> getAll() {
		return repo.findAll();
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
	
	@Override
	public Optional<?> getOne(String username, String password) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	@Override
	public Account save(Account account) {
		Account acc = new Account();
		acc.setUsername(account.getUsername());
		acc.setPassword(passwordEncoder.encode(account.getPassword()));
		acc.setRole(Constant.eRole.CUSTOMER.ordinal()); //mặc định lúc đăng kí là customer. admin thì tự thêm hoặc vô sql sửa role lại 
		return repo.save(acc);
	}

	@Override
	public Account findByUsername(String name) {
		// TODO Auto-generated method stub
		return repo.findByUsername(name);
	}

	@Override
	public boolean create(Optional<?> object) {
		// TODO Auto-generated method stub
		repo.save((Account) object.get());
		return true;
	}







}

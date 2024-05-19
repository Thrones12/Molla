package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.Utils.Constant;
import DaiHoc.Molla.entity.Account;
import DaiHoc.Molla.repository.AccountRepository;
import DaiHoc.Molla.service.IAccountService;

@Service
public class AccountService implements IAccountService {
	@Autowired
	private AccountRepository repo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Account save(Account account) {
		Account acc = new Account();
		acc.setUsername(account.getUsername());
		acc.setPassword(passwordEncoder.encode(account.getPassword()));
		acc.setRole(Constant.eRole.CUSTOMER.ordinal()); // mặc định lúc đăng kí là customer. admin thì tự thêm hoặc vô
														// sql sửa role lại
		return repo.save(acc);
	}

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

package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Account;


@Component
public interface IAccountService {
	List<Account> getAll();
	Boolean update(Account account);
	Boolean delete(Long Id);
	Account findById(Long id);
	Account findAccountByUserId(Long userId);
	
	
	
	Account findByUsername(String name);
	Account save(Account account);	
	boolean create(Optional<?> object);
	Optional<?> getOne(String username, String password);

}



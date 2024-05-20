package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Account;


@Component
public interface IAccountService {
	List<Account> findAll();
	Account findOne(Long id);
	Account findOne(String username);
	
	Account create(Account account);
	Account update(Account object);
	boolean delete(Long id);
	
	Account findAccountByUserId(Long id);
}

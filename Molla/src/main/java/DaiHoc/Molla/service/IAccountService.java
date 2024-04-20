package DaiHoc.Molla.service;

import java.util.List;


import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Account;


@Component
public interface IAccountService {
	List<Account> getAll();
	Boolean save(Account account);
	Boolean update(Account account);
	Boolean delete(Long Id);
	Account findById(Long id);
	Account findAccountByUserId(Long userId);
}

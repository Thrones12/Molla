package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Account;


@Component
public interface IAccountService {
	Optional<?> getAll();
	Account findOne(Long id);
	Account findOne(String username);
	boolean create(Optional<?> object);
	boolean update(Account object);
	boolean delete(Long id);
	Account save(Account account);
	Account findAccountByUserId(Long id);
}

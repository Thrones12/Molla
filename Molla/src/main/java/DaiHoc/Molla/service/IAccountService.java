package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Account;

@Component
public interface IAccountService {
	List<Account> getAll();
}

package DaiHoc.Molla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByUsername(String username);

	Account findAccountByUserId(Long userId);
}

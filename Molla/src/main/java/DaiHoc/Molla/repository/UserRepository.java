package DaiHoc.Molla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

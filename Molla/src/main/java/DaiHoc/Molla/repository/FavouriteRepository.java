package DaiHoc.Molla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long>{
	List<Favourite> findByUser_id(Long user_id);
}

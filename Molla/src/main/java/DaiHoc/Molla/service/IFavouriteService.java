package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Favourite;

@Component
public interface IFavouriteService {
	Optional<?> findAll();
	Optional<?> findByUser(Long user_id);
	
	boolean insert(Favourite fav);
	boolean update(Favourite fav);
	boolean delete(Long fav_id);
	
	boolean setState(List<Favourite> favs);
}

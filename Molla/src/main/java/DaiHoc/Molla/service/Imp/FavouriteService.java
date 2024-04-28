package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Favourite;
import DaiHoc.Molla.repository.FavouriteRepository;
import DaiHoc.Molla.repository.StockRepository;
import DaiHoc.Molla.service.IFavouriteService;

@Service
public class FavouriteService implements IFavouriteService{
	@Autowired
	private FavouriteRepository repo;
	@Autowired
	private StockRepository stockRepo;
	@Override
	public Optional<?> findAll() {
		return Optional.ofNullable(repo.findAll());
	}

	@Override
	public Optional<?> findByUser(Long user_id) {
		return Optional.ofNullable(repo.findByUser_id(user_id));
	}

	@Override
	public boolean insert(Favourite fav) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Favourite fav) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long fav_id) {
		try {
			repo.deleteById(fav_id);;
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean setState(List<Favourite> favs) {
		try {
			for (Favourite fav : favs) {
				if (stockRepo.findAllByProduct_IdAndState(fav.getProduct().getId(), 0).size()>0) {
					fav.setState(0);
				}
				else {
					fav.setState(1);
				}
			}
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

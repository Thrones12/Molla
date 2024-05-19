package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.PromotionalEvent;
import DaiHoc.Molla.repository.PromotionalEventRepository;
import DaiHoc.Molla.service.IPromotionalEventService;
@Service
public class PromotionalEventService implements IPromotionalEventService
{
	@Autowired
	private PromotionalEventRepository repo;

	@Override
	public List<PromotionalEvent> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<?> getOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean create(Optional<?> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Optional<?> object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	

}

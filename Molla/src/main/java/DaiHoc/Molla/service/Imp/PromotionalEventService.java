package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.PromotionalEvent;
import DaiHoc.Molla.repository.PromotionalEventRepository;
import DaiHoc.Molla.service.IPromotionalEventService;
@Service
public class PromotionalEventService implements IPromotionalEventService
{
	@Autowired
	private PromotionalEventRepository repo;
	@Override
	public List<PromotionalEvent> getAll() {
		return repo.findAll();
	}
	
	@Override
	public Boolean save(PromotionalEvent event) {
		// TODO Auto-generated method stub
		try {
			repo.save(event);
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}
	@Override
	public Boolean update(PromotionalEvent event) {
		try {
			Optional<PromotionalEvent> opt = Optional.of(findById(event.getId()));
			if (opt.isPresent()) {
				repo.save(event);
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Boolean delete(Long Id) {
		try {
			repo.delete(findById(Id));
			return true;
		}
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 return false;
	}
	
	
	@Override
	public PromotionalEvent findById(Long id) {
	    return repo.findById(id).orElse(null); 
	}

}

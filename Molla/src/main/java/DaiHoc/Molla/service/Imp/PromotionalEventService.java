package DaiHoc.Molla.service.Imp;

import java.util.List;

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
	public List<PromotionalEvent> getAll() {
		return repo.findAll();
	}

}

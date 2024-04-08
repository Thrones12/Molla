package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.PromotionalType;
import DaiHoc.Molla.repository.PromotionalTypeRepository;
import DaiHoc.Molla.service.IPromotionalTypeService;
@Service
public class PromotionalTypeService implements IPromotionalTypeService
{
	@Autowired
	private PromotionalTypeRepository repo;
	@Override
	public List<PromotionalType> getAll() {
		return repo.findAll();
	}

}

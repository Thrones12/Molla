package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.PromotionalCode;
import DaiHoc.Molla.repository.PromotionalCodeRepository;
import DaiHoc.Molla.service.IPromotionalCodeService;
@Service
public class PromotionalCodeService implements IPromotionalCodeService
{
	@Autowired
	private PromotionalCodeRepository repo;
	@Override
	public List<PromotionalCode> getAll() {
		return repo.findAll();
	}

}

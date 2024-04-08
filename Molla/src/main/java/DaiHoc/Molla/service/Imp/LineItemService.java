package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.LineItem;
import DaiHoc.Molla.repository.LineItemRepository;
import DaiHoc.Molla.service.ILineItemService;
@Service
public class LineItemService implements ILineItemService
{
	@Autowired
	private LineItemRepository repo;
	@Override
	public List<LineItem> getAll() {
		return repo.findAll();
	}

}

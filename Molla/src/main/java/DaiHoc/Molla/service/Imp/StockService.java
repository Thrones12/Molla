package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Stock;
import DaiHoc.Molla.repository.StockRepository;
import DaiHoc.Molla.service.IStockService;
@Service
public class StockService implements IStockService
{
	@Autowired
	private StockRepository repo;
	@Override
	public List<Stock> getAll() {
		return repo.findAll();
	}

}

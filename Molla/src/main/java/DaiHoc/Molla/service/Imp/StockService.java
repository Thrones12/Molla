package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Product;
import DaiHoc.Molla.entity.Stock;
import DaiHoc.Molla.repository.StockRepository;
import DaiHoc.Molla.service.IStockService;
@Service
public class StockService implements IStockService
{
	@Autowired
	private StockRepository repo;

	@Override
	public Optional<?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<?> getOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean insert(Optional<?> object) {
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

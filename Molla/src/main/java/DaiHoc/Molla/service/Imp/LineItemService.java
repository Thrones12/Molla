package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

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
	public Optional<?> getOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	@Override
	public Optional<?> findNew(){
		return repo.findFirstByOrderByIdDesc();
	}
	@Override
	public boolean create(Optional<?> object) {
		try {
			repo.save((LineItem) object.get());
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
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
	@Override
	public Optional<?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

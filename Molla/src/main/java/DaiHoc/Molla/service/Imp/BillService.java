package DaiHoc.Molla.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Bill;
import DaiHoc.Molla.repository.BillRepository;
import DaiHoc.Molla.service.IBillService;
@Service
public class BillService implements IBillService{
	@Autowired
	private BillRepository repo;
	@Override
	public Optional<?> findOne(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<?> findByUser_id(Long user_id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean create(Optional<?> object) {
		try {
			repo.save((Bill)object.get());
			repo.flush();
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

}

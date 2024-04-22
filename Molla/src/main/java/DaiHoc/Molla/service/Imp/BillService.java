package DaiHoc.Molla.service.Imp;

import java.util.List;

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
	public List<Bill> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Boolean save(Bill account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Bill account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Bill> findBillByUserId(Long userId) {
		// TODO Auto-generated method stub
		return repo.findBillByUserId(userId);
	}

}

package DaiHoc.Molla.service.Imp;

import java.sql.Date;
import java.time.LocalDate;
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
	public Bill findOne(Long id) {
		return repo.findById(id).get();
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
	public Bill createAndReturn(Bill bill) {
		try {
	        Bill savedBill = repo.save(bill);
	        return savedBill;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(Bill object) {
		try {
			new Bill();
			Bill bill = Bill.builder().user(object.getUser())
					.product_price(object.getProduct_price())
					.ship(object.getShip())
					.total_price(object.getTotal_price())
					.bill_date(object.getBill_date())
					.state(object.getState())
					.receiver(object.getReceiver())
					.address_shipment(object.getAddress_shipment())
					.phone_shipment(object.getPhone_shipment())
					.email(object.getEmail())
					.note(object.getNote())
					.promotionalCode(object.getPromotionalCode())
					.build();
			repo.save(bill);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Long id) {
		try {
			repo.delete(findOne(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

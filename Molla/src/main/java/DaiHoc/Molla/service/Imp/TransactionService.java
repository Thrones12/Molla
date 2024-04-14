package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Transaction;
import DaiHoc.Molla.repository.TransactionRepository;
import DaiHoc.Molla.service.ITransactionService;
@Service
public class TransactionService implements ITransactionService
{
	@Autowired
	private TransactionRepository repo;

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
	public boolean create(Optional<?> object) {
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

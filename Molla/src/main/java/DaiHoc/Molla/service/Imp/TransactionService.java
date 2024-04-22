package DaiHoc.Molla.service.Imp;

import java.util.List;

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
	public List<Transaction> getAll() {
		return repo.findAll();
	}
	@Override
	public List<Transaction> findTransactionByBillId(Long Id) {
		// TODO Auto-generated method stub
		return repo.findTransactionByBillId(Id);
	}

}

package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Transaction;

@Component
public interface ITransactionService {
	List<Transaction> getAll();
}

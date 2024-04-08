package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Stock;

@Component
public interface IStockService {
	List<Stock> getAll();
}

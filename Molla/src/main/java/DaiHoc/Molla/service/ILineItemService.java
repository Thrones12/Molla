package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.LineItem;

@Component
public interface ILineItemService {
	List<LineItem> getAll();
}

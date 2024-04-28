package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.entity.PromotionalEvent;

@Component
public interface IPromotionalEventService {
	List<PromotionalEvent> getAll();
	Boolean save(PromotionalEvent promotionalEvent);
	Boolean update(PromotionalEvent promotionalEvent);
	PromotionalEvent findById(Long id);
	Boolean delete(Long Id);
}

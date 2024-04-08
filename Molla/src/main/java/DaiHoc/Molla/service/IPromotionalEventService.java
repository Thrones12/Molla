package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.PromotionalEvent;

@Component
public interface IPromotionalEventService {
	List<PromotionalEvent> getAll();
}

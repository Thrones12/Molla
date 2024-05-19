package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.PromotionalEvent;


@Component
public interface IPromotionalEventService {
	List<PromotionalEvent> findAll();
	PromotionalEvent findOne(Long id);
	boolean create(PromotionalEvent object);
	boolean update(PromotionalEvent object);
	boolean delete(Long id);
}

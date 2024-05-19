package DaiHoc.Molla.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.PromotionalEvent;


@Component
public interface IPromotionalEventService {
	List<PromotionalEvent> findAll();
	Optional<?> getOne(Long id);
	boolean create(Optional<?> object);
	boolean update(Optional<?> object);
	boolean delete(Long id);
}

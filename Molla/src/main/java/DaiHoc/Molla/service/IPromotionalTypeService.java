package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.PromotionalType;

@Component
public interface IPromotionalTypeService {
	List<PromotionalType> getAll();
}

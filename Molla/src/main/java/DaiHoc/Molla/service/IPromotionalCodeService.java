package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.PromotionalCode;

@Component
public interface IPromotionalCodeService {
	List<PromotionalCode> getAll();

}

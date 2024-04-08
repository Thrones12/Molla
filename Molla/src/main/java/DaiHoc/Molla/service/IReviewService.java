package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Review;

@Component
public interface IReviewService {
	List<Review> getAll();
}

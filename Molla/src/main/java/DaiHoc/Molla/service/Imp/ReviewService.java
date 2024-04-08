package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Review;
import DaiHoc.Molla.repository.ReviewRepository;
import DaiHoc.Molla.service.IReviewService;
@Service
public class ReviewService implements IReviewService
{
	@Autowired
	private ReviewRepository repo;
	@Override
	public List<Review> getAll() {
		return repo.findAll();
	}

}

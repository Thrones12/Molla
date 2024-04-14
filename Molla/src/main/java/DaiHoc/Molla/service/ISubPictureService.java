package DaiHoc.Molla.service;

import java.util.Optional;

import org.springframework.stereotype.Component;
@Component
public interface ISubPictureService {
	Optional<?> getAllByProducID(Long pro_id);
}

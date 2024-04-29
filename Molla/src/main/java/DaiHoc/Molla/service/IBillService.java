package DaiHoc.Molla.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public interface IBillService {
	Optional<?> findOne(Long id);
	Optional<?> findByUser_id(Long user_id);
	
	boolean create(Optional<?> object);
	boolean update(Optional<?> object);
	boolean delete(Long id);
}

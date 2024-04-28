package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.entity.Product;

@Component
public interface IManufacturerService {
	List<Manufacturer> getAll();
	
	boolean save(Manufacturer manufacturer);
	boolean update(Manufacturer manufacturer);
	boolean delete(Long id);
	Manufacturer findById(Long id);

}

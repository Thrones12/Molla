package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.stereotype.Component;

import DaiHoc.Molla.entity.Manufacturer;

@Component
public interface IManufacturerService {
	List<Manufacturer> getAll();
}

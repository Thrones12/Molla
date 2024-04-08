package DaiHoc.Molla.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Manufacturer;
import DaiHoc.Molla.repository.ManufacturerRepository;
import DaiHoc.Molla.service.IManufacturerService;
@Service
public class ManufacturerService implements IManufacturerService
{
	@Autowired
	private ManufacturerRepository repo;
	@Override
	public List<Manufacturer> getAll() {
		return repo.findAll();
	}

}

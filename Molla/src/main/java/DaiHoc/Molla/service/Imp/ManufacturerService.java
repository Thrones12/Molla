package DaiHoc.Molla.service.Imp;

import java.util.List;
import java.util.Optional;

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
	@Override
	public boolean save(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		try {
			repo.save(manufacturer);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean update(Manufacturer manufacturer) {
		// TODO Auto-generated method stub
		try {
			repo.save(manufacturer);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		try {
			repo.delete(findById(id));
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Manufacturer findById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}

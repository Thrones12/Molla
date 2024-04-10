package DaiHoc.Molla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.repository.CategoryRepository;
@Service
public class demo implements ICategoryService{
	public static void main(String[] args) {
		System.out.println("asd");
		
	}
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

package DaiHoc.Molla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.repository.CategoryRepository;


@SpringBootApplication
public class MollaApplication {
	@Autowired
	private static CategoryRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(MollaApplication.class, args);
	}

//    public void run(String... args) throws Exception {
//        // Logic to save category
//        repo.save(new Category());
//    }
}

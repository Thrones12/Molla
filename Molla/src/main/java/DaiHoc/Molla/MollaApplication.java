package DaiHoc.Molla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import DaiHoc.Molla.entity.Category;
import DaiHoc.Molla.repository.CategoryRepository;
import DaiHoc.Molla.service.IStorageService;


@SpringBootApplication
public class MollaApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(MollaApplication.class, args);
	}
	@Bean
	CommandLineRunner init(IStorageService storageservice) {
		return (args) -> {
			storageservice.init();
		};
		
	}

//    public void run(String... args) throws Exception {
//        // Logic to save category
//        repo.save(new Category());
//    }
}

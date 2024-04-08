package DaiHoc.Molla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DaiHoc.Molla.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

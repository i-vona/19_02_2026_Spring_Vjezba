package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
}

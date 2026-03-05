package hr.java.spring.boot.Example.repository;

import hr.java.spring.boot.Example.domain.Category;
import hr.java.spring.boot.Example.domain.Hardware;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface SpringDataHardwareRepository extends JpaRepository<Hardware, Long>, JpaSpecificationExecutor<Hardware> {

    List<Hardware> findByName(String name);

}

package learn.spring.boot.tutorial.repositories;


import learn.spring.boot.tutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeeEntity,Long> {

}

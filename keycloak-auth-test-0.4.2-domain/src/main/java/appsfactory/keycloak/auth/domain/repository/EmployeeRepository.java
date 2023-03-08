package appsfactory.keycloak.auth.domain.repository;

import appsfactory.keycloak.auth.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
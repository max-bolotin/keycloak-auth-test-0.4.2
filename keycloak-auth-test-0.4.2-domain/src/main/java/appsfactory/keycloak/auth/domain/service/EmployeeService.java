package appsfactory.keycloak.auth.domain.service;

import appsfactory.keycloak.auth.domain.model.Employee;
import java.util.List;

public interface EmployeeService {
  public Employee getEmployee(Long id);

  public List<Employee> getAllEmployees();
}
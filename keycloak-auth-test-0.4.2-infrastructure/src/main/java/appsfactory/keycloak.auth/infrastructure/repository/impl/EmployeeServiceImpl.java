package appsfactory.keycloak.auth.infrastructure.repository.impl;

import appsfactory.keycloak.auth.domain.model.Employee;
import appsfactory.keycloak.auth.domain.service.EmployeeService;
import appsfactory.keycloak.auth.infrastructure.repository.EmployeeRepository;
import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee getEmployee(Long id) {
    return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("no user found with id " + id));
  }

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @PostConstruct
  public void initializeEmployeeTable() {
    employeeRepository.saveAll(Stream.of(
        new Employee("john", 3000),
        new Employee("bob", 4000),
        new Employee("alice", 5000)
    )
        .collect(Collectors.toList()));
  }
}
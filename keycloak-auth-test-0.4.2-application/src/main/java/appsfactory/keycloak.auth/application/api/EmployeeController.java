package appsfactory.keycloak.auth.application.api;

import appsfactory.keycloak.auth.domain.model.Employee;
import appsfactory.keycloak.auth.domain.service.EmployeeService;
import javax.annotation.security.RolesAllowed;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService service;

  public EmployeeController(EmployeeService service) {
    this.service = service;
  }

  @GetMapping("/{employeeId}")
  @RolesAllowed("user")
  public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId) {
    return ResponseEntity.ok(service.getEmployee(employeeId));
  }

  //this method can be only access by user whose role is admin
  @GetMapping
  @RolesAllowed("admin")
  public ResponseEntity<List<Employee>> getAllEmployees() {
    return ResponseEntity.ok(service.getAllEmployees());
  }
}
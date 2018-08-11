package ru.hh.school.coolService.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.stream.Collectors;
import ru.hh.school.coolService.entities.Employee;

public class EmployeeDto {
  public Integer id;
  public String firstName;
  public String lastName;
  public String email;
  @JsonManagedReference
  public List<ResumeDto> resumes;

  public EmployeeDto(){
  }

  public EmployeeDto(Employee employee){
    id = employee.getId();
    firstName = employee.getFirstName();
    lastName = employee.getLastName();
    email = employee.getEmail();
    if (employee.getResumes() != null) {
      resumes = employee.getResumes().stream().map(ResumeDto::new).collect(Collectors.toList());
    }
  }
}

package ru.hh.school.coolService.services;

import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.springframework.transaction.annotation.Transactional;
import ru.hh.school.coolService.dao.EmployeeDao;
import ru.hh.school.coolService.dao.ResumeDao;
import ru.hh.school.coolService.dto.EmployeeCreateDto;
import ru.hh.school.coolService.dto.EmployeeDto;
import ru.hh.school.coolService.dto.ResumeCreateDto;
import ru.hh.school.coolService.dto.ResumeDto;
import ru.hh.school.coolService.entities.Employee;
import ru.hh.school.coolService.entities.Resume;

public class EmployeeService {

  private EmployeeDao employeeDao;
  private ResumeDao resumeDao;

  @Inject
  public EmployeeService(EmployeeDao employeeDao, ResumeDao resumeDao) {
    this.employeeDao = employeeDao;
    this.resumeDao = resumeDao;
  }

  @Transactional
  public EmployeeDto createEmployee(EmployeeCreateDto employeeCreateDto) {
    Employee employee = new Employee();
    employee.setFirstName(employeeCreateDto.firstName);
    employee.setLastName(employeeCreateDto.lastName);
    employee.setEmail(employeeCreateDto.email);

    employeeDao.save(employee);
    return new EmployeeDto(employee);
  }

  @Transactional
  public ResumeDto createResume(ResumeCreateDto resumeCreateDto) {
    Resume resume = new Resume();
    resume.setEmployee(employeeDao.getById(resumeCreateDto.employeeId));
    resume.setPosition(resumeCreateDto.position);
    resume.setAbout(resumeCreateDto.about);

    resumeDao.save(resume);
    return new ResumeDto(resume);
  }

  @Transactional(readOnly = true)
  public EmployeeDto getEmployeeById(Integer id) {
    return new EmployeeDto(employeeDao.getById(id));
  }

  @Transactional(readOnly = true)
  public ResumeDto getResumeById(Integer id) {
    return new ResumeDto(resumeDao.getById(id));
  }

}

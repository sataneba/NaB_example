package ru.hh.school.coolService.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import ru.hh.school.coolService.entities.Employee;
import ru.hh.school.coolService.entities.Resume;

public class ResumeDto {
  public Integer id;
  @JsonBackReference
  public Employee employee;
  public String position;
  public String about;

  public ResumeDto(){
  }

  public ResumeDto(Resume resume){
    id = resume.getId();
    employee = resume.getEmployee();
    position = resume.getPosition();
    about = resume.getAbout();
  }
}

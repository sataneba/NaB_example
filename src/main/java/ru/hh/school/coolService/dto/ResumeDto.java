package ru.hh.school.coolService.dto;

import ru.hh.school.coolService.entities.Resume;

public class ResumeDto {
  public Integer id;
  public Integer employeeId;
  public String position;
  public String about;

  public ResumeDto(){
  }

  public ResumeDto(Resume resume){
    id = resume.getId();
    employeeId = resume.getEmployee().getId();
    position = resume.getPosition();
    about = resume.getAbout();
  }
}

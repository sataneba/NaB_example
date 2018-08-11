package ru.hh.school.coolService.dao;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import ru.hh.school.coolService.entities.Employee;

public class EmployeeDao {
  private final SessionFactory sessionFactory;

  @Inject
  public EmployeeDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void save(Employee employee) {
    sessionFactory.getCurrentSession().save(employee);
  }

  public Employee getById(Integer id) {
    return sessionFactory.getCurrentSession().get(Employee.class, id);
  }

}

package ru.hh.school.coolService.dao;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import ru.hh.school.coolService.entities.Resume;

public class ResumeDao {
  private final SessionFactory sessionFactory;

  @Inject
  public ResumeDao(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void save(Resume resume) {
    sessionFactory.getCurrentSession().save(resume);
  }

  public Resume getById(Integer id) {
    return sessionFactory.getCurrentSession().get(Resume.class, id);
  }
}

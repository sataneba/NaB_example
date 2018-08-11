package ru.hh.school.coolService.dao;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
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

  public List<Resume> getAllRecords() {
    Session session = sessionFactory.getCurrentSession();
    return session.createQuery("from Resume", Resume.class).list();
  }
}

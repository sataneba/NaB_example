package ru.hh.school.coolService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.hh.nab.core.CoreProdConfig;
import ru.hh.nab.core.util.FileSettings;
import ru.hh.nab.hibernate.DataSourceFactory;
import ru.hh.nab.hibernate.HibernateProdConfig;
import ru.hh.nab.hibernate.MappingConfig;
import ru.hh.nab.hibernate.datasource.DataSourceType;
import ru.hh.school.coolService.dao.EmployeeDao;
import ru.hh.school.coolService.dao.ResumeDao;
import ru.hh.school.coolService.entities.Employee;
import ru.hh.school.coolService.entities.Resume;
import ru.hh.school.coolService.resources.EmployeeResource;

import javax.sql.DataSource;
import ru.hh.school.coolService.services.EmployeeService;

@Configuration
@Import({
    CoreProdConfig.class,
    HibernateProdConfig.class,
    EmployeeResource.class,
    EmployeeDao.class,
    ResumeDao.class,
    EmployeeService.class
})
public class ProdConfig {

  @Bean
  MappingConfig mappingConfig() {
    return new MappingConfig(
        Resume.class,
        Employee.class
    );
  }

  @Bean
  DataSource dataSource(DataSourceFactory dataSourceFactory, FileSettings settings) {
    return dataSourceFactory.create(DataSourceType.MASTER, settings);
  }
}

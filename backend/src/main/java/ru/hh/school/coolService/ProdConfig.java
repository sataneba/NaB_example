package ru.hh.school.coolService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.hh.nab.core.CoreProdConfig;
import ru.hh.nab.hibernate.HibernateProdConfig;
import ru.hh.nab.hibernate.MappingConfig;
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

  @Bean(destroyMethod = "shutdown")
  DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.HSQL)
        .addScript("db/sql/create-db.sql")
        .addScript("db/sql/insert-data.sql")
        .build();
  }
}

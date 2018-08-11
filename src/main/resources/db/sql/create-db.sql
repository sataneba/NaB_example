CREATE TABLE employee
(
  id              INTEGER IDENTITY PRIMARY KEY,
  first_name      VARCHAR(256) NOT NULL,
  last_name       VARCHAR(256) NOT NULL,
  email           VARCHAR(128) NOT NULL
);

CREATE TABLE resume
(
  id              INTEGER IDENTITY PRIMARY KEY,
  employee_id     INTEGER NOT NULL,
  position        VARCHAR(128) NOT NULL,
  about           VARCHAR(256) NOT NULL,
  FOREIGN KEY (employee_id) REFERENCES employee(id)
);

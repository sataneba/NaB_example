CREATE TABLE employee
(
  id              SERIAL PRIMARY KEY,
  first_name      VARCHAR(256)         NOT NULL,
  last_name       VARCHAR(256)         NOT NULL,
  email           VARCHAR(128)         NOT NULL
);

CREATE TABLE resume
(
  id              SERIAL PRIMARY KEY,
  employee_id     INT REFERENCES employee(id) NOT NULL,
  position        VARCHAR(128)                NOT NULL,
  about           text                        NOT NULL
);

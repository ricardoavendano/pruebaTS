 /*-------------------------------------------------------------------------------------------*/
DROP TABLE IF EXISTS empleado;
CREATE TABLE empleado (
  idempleado INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  PRIMARY KEY (idempleado));

INSERT INTO empleado (nombre) VALUES
('Ricardo'),
('Juan'),
('Pedro'),
('Jose'),
('Carlos');

/*-------------------------------------------------------------------------------------------*/

DROP TABLE IF EXISTS actividad;
CREATE TABLE actividad (
  idactividad INT NOT NULL AUTO_INCREMENT,
  idempleadoPK INT NOT NULL,
  estado INT NOT NULL,
  fechaejecucion DATE NULL,
  fechacierre DATE NULL,
  PRIMARY KEY (idactividad));

ALTER TABLE actividad 
ADD CONSTRAINT idempleadoPK
  FOREIGN KEY (idempleadoPK)
  REFERENCES empleado (idempleado);

INSERT INTO actividad (idempleadoPK, estado, fechaejecucion, fechacierre) VALUES 
(1, 1, DATE'2022-06-14', DATE'2022-06-14'),
(2, 2, DATE'2022-06-13', NULL),
(3, 1, DATE'2022-06-13', DATE'2022-06-14'),
(4, 2, DATE'2022-06-15', NULL);
/*-------------------------------------------------------------------------------------------*/
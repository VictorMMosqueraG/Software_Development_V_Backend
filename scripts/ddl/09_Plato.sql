CREATE TABLE plato (
  pla_id int(11) NOT NULL AUTO_INCREMENT,
  pla_descripcion varchar(40),
  pla_precio float,
  est_id int(11),
  PRIMARY KEY (pla_id),
  KEY est_id (est_id),
  CONSTRAINT plato_ibfk_1 FOREIGN KEY (est_id)
    REFERENCES estado(est_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
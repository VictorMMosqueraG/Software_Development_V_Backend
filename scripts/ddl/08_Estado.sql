CREATE TABLE estado (
  est_id int(11) NOT NULL AUTO_INCREMENT,
  est_descripcion varchar(40),
  tes_id int(2) NOT NULL,
  est_estado varchar(10) NOT NULL,
  PRIMARY KEY (est_id),
  KEY tes_id (tes_id),
  CONSTRAINT estado_ibfk_1 FOREIGN KEY (tes_id)
    REFERENCES tipo_estado(tes_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
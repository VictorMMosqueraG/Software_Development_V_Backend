CREATE TABLE pqrs (
  pqrs_id int(4) NOT NULL AUTO_INCREMENT,
  pqrs_fecha date NOT NULL,
  pqrs_descripcion blob NOT NULL,
  pqrs_correo varchar(60) NOT NULL,
  pqrs_telefono varchar(20) NOT NULL,
  tpqrs_id int(2) NOT NULL,
  est_id int(2) NOT NULL,
  pqrs_respuesta blob NOT NULL,
  PRIMARY KEY (pqrs_id),
  KEY tpqrs_id (tpqrs_id),
  KEY est_id (est_id),
  CONSTRAINT pqrs_ibfk_1 FOREIGN KEY (est_id)
    REFERENCES estado(est_id),
  CONSTRAINT pqrs_ibfk_2 FOREIGN KEY (tpqrs_id)
    REFERENCES tipo_tpqrs(tpqrs_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
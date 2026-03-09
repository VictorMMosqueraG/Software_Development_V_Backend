CREATE TABLE tipo_tpqrs (
  tpqrs_id int(2) NOT NULL AUTO_INCREMENT,
  tpqrs_descripcion varchar(40) DEFAULT NULL,
  tpqrs_estado varchar(10) DEFAULT NULL,
  PRIMARY KEY (tpqrs_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
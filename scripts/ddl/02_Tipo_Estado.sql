CREATE TABLE tipo_estado (
  tes_id int(2) NOT NULL AUTO_INCREMENT,
  tes_descripcion varchar(40) NOT NULL,
  tes_estado varchar(10) NOT NULL,
  PRIMARY KEY (tes_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
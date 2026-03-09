CREATE TABLE concepto (
  con_id int(3) NOT NULL AUTO_INCREMENT,
  con_descripcion varchar(100) NOT NULL,
  con_estado varchar(10) NOT NULL,
  PRIMARY KEY (con_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
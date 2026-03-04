CREATE TABLE forma_pago (
  fp_id int(2) NOT NULL AUTO_INCREMENT,
  fp_descripcion varchar(50) NOT NULL,
  fp_estado varchar(15) NOT NULL,
  PRIMARY KEY (fp_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
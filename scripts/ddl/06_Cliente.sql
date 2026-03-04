CREATE TABLE cliente (
  cli_id int(15) NOT NULL AUTO_INCREMENT,
  cli_nombre varchar(60) DEFAULT NULL,
  cli_apellidos varchar(60) DEFAULT NULL,
  cli_direccion varchar(40) DEFAULT NULL,
  cli_telefono varchar(40) DEFAULT NULL,
  cli_correo varchar(40) NOT NULL,
  cli_estado varchar(10) NOT NULL,
  PRIMARY KEY (cli_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

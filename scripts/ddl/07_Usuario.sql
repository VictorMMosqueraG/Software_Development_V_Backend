CREATE TABLE usuario (
  usu_id int(11) NOT NULL AUTO_INCREMENT,
  usu_nombre varchar(60) NOT NULL,
  usu_apellido varchar(60) NOT NULL,
  usu_direccion varchar(100) NOT NULL,
  usu_telefono varchar(20) NOT NULL,
  usu_correo varchar(70) NOT NULL,
  perf_id int(11),
  usu_login varchar(30) NOT NULL,
  usu_pass varchar(30) NOT NULL,
  usu_estado varchar(10),
  PRIMARY KEY (usu_id),
  KEY perf_id (perf_id),
  CONSTRAINT usuario_ibfk_1 FOREIGN KEY (perf_id)
    REFERENCES perfil(perf_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE perfil (
  perf_id int(11) NOT NULL AUTO_INCREMENT,
  perf_descripcion varchar(40) DEFAULT NULL,
  perf_estado varchar(20) DEFAULT NULL,
  PRIMARY KEY (perf_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
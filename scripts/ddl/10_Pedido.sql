CREATE TABLE pedido (
  ped_id int(11) NOT NULL AUTO_INCREMENT,
  ped_fecha date,
  usu_id int(11),
  ped_mesa varchar(4) NOT NULL,
  est_id int(11),
  PRIMARY KEY (ped_id),
  KEY usu_id (usu_id),
  KEY est_id (est_id),
  CONSTRAINT pedido_ibfk_1 FOREIGN KEY (est_id)
    REFERENCES estado(est_id),
  CONSTRAINT pedido_ibfk_2 FOREIGN KEY (usu_id)
    REFERENCES usuario(usu_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
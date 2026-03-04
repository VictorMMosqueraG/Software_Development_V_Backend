CREATE TABLE recibo_caja (
  rc_num int(11) NOT NULL AUTO_INCREMENT,
  usu_id int(15) NOT NULL,
  rc_fecha date NOT NULL,
  ped_id int(11) NOT NULL,
  cli_id int(15) NOT NULL,
  rc_total double NOT NULL,
  rc_observacion varchar(360) NOT NULL,
  rc_estado varchar(10) NOT NULL,
  PRIMARY KEY (rc_num),
  KEY ped_id (ped_id),
  KEY cli_id (cli_id),
  KEY usu_id (usu_id),
  CONSTRAINT recibo_caja_ibfk_1 FOREIGN KEY (ped_id)
    REFERENCES pedido(ped_id),
  CONSTRAINT recibo_caja_ibfk_2 FOREIGN KEY (cli_id)
    REFERENCES cliente(cli_id),
  CONSTRAINT recibo_caja_ibfk_3 FOREIGN KEY (usu_id)
    REFERENCES usuario(usu_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
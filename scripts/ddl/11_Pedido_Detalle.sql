CREATE TABLE pedido_detalle (
  ped_det_id int(11) NOT NULL AUTO_INCREMENT,
  ped_det_cant int(11),
  ped_det_precio float,
  ped_det_obser varchar(40),
  pla_id int(11),
  ped_id int(11),
  est_id int(2) NOT NULL,
  PRIMARY KEY (ped_det_id),
  KEY pla_id (pla_id),
  KEY ped_id (ped_id),
  CONSTRAINT pedido_detalle_ibfk_1 FOREIGN KEY (pla_id)
    REFERENCES plato(pla_id),
  CONSTRAINT pedido_detalle_ibfk_2 FOREIGN KEY (ped_id)
    REFERENCES pedido(ped_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
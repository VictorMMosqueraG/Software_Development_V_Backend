CREATE TABLE recibo_caja_detalle (
  rcd_id int(11) NOT NULL AUTO_INCREMENT,
  rcd_num int(11) NOT NULL,
  pla_id int(4) NOT NULL,
  rcd_precio double NOT NULL,
  rcd_cantidad double NOT NULL,
  PRIMARY KEY (rcd_id),
  KEY rcd_num (rcd_num),
  KEY pla_id (pla_id),
  CONSTRAINT recibo_caja_detalle_ibfk_1 FOREIGN KEY (pla_id)
    REFERENCES plato(pla_id),
  CONSTRAINT recibo_caja_detalle_ibfk_2 FOREIGN KEY (rcd_num)
    REFERENCES recibo_caja(rc_num)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
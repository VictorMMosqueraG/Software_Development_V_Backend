CREATE TABLE comanda (
  com_id int(11) NOT NULL AUTO_INCREMENT,
  mesa int(2),
  pla_id int(11),
  com_obs varchar(60) NOT NULL,
  est_id int(11),
  PRIMARY KEY (com_id),
  KEY pla_id (pla_id),
  KEY est_id (est_id),
  CONSTRAINT comanda_ibfk_1 FOREIGN KEY (pla_id)
    REFERENCES plato(pla_id),
  CONSTRAINT comanda_ibfk_2 FOREIGN KEY (est_id)
    REFERENCES estado(est_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
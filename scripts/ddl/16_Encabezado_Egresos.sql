CREATE TABLE encabezado_egresos (
  id int(11) NOT NULL AUTO_INCREMENT,
  no_egreso int(11) NOT NULL,
  fecha_documento timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
    ON UPDATE CURRENT_TIMESTAMP,
  tercero_identificacion varchar(15) NOT NULL,
  detalle varchar(250) NOT NULL,
  fp_id int(3) NOT NULL,
  conceptoEgreso_codigo int(4) NOT NULL,
  no_documento varchar(15) NOT NULL,
  valor_egreso double NOT NULL,
  estado varchar(10) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
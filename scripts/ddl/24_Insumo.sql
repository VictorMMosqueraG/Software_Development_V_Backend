CREATE TABLE IF NOT EXISTS insumo (
  ins_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  sede_id BIGINT UNSIGNED NOT NULL,
  cins_id BIGINT UNSIGNED NOT NULL,
  pres_id BIGINT UNSIGNED NOT NULL,
  ins_nombre VARCHAR(150) NOT NULL,
  ins_codigo VARCHAR(30) DEFAULT NULL,
  ins_codigo_barras VARCHAR(50) DEFAULT NULL,
  ins_precio_compra DECIMAL(10,2) DEFAULT NULL,
  ins_stock DECIMAL(12,3) NOT NULL DEFAULT 0.000,
  ins_stock_min DECIMAL(12,3) NOT NULL DEFAULT 0.000,
  ins_vendible TINYINT(1) NOT NULL DEFAULT 0,
  ins_imagen VARCHAR(255) DEFAULT NULL,
  ins_estado TINYINT(1) NOT NULL DEFAULT 1,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (ins_id),
  UNIQUE KEY uk_ins_codigo_barras (ins_codigo_barras),
  KEY fk_insumo_sede (sede_id),
  KEY fk_insumo_categoria (cins_id),
  KEY fk_insumo_presentacion (pres_id),
  CONSTRAINT fk_insumo_sede FOREIGN KEY (sede_id)
    REFERENCES sede(sede_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_insumo_categoria FOREIGN KEY (cins_id)
    REFERENCES categoria_insumo(cins_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_insumo_presentacion FOREIGN KEY (pres_id)
    REFERENCES presentacion(pres_id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

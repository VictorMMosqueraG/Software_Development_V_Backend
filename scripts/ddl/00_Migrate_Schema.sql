-- =============================================================
-- Migration script: Update existing tables to match PDF schema
-- Restaurant 2026 Multisede
-- =============================================================

SET FOREIGN_KEY_CHECKS = 0;

-- -----------------------------------------------
-- 1. Recreate perfil table
-- -----------------------------------------------
DROP TABLE IF EXISTS perfil;
CREATE TABLE perfil (
  perf_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  perf_descripcion VARCHAR(60) NOT NULL,
  perf_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (perf_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 2. Recreate usuario table
-- -----------------------------------------------
DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
  usu_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  usu_nombre VARCHAR(60) NOT NULL,
  usu_apellido VARCHAR(60) NOT NULL,
  usu_direccion VARCHAR(100) NOT NULL,
  usu_telefono VARCHAR(20) NOT NULL,
  usu_correo VARCHAR(100) NOT NULL,
  email_verified_at TIMESTAMP DEFAULT NULL,
  perf_id BIGINT UNSIGNED DEFAULT NULL,
  usu_login VARCHAR(30) NOT NULL,
  usu_pass VARCHAR(255) NOT NULL,
  remember_token VARCHAR(100) DEFAULT NULL,
  usu_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (usu_id),
  UNIQUE KEY uk_usu_correo (usu_correo),
  UNIQUE KEY uk_usu_login (usu_login),
  KEY fk_usuario_perfil (perf_id),
  CONSTRAINT fk_usuario_perfil FOREIGN KEY (perf_id)
    REFERENCES perfil(perf_id) ON UPDATE CASCADE ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 3. Recreate sede table
-- -----------------------------------------------
DROP TABLE IF EXISTS sede;
CREATE TABLE sede (
  sede_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  sede_nombre VARCHAR(120) NOT NULL,
  sede_direccion VARCHAR(200) DEFAULT NULL,
  sede_telefono VARCHAR(30) DEFAULT NULL,
  sede_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (sede_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 4. Recreate tipo_estado table
-- -----------------------------------------------
DROP TABLE IF EXISTS tipo_estado;
CREATE TABLE tipo_estado (
  tes_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  tes_descripcion VARCHAR(50) NOT NULL,
  tes_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (tes_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 5. Recreate estado table
-- -----------------------------------------------
DROP TABLE IF EXISTS estado;
CREATE TABLE estado (
  est_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  est_descripcion VARCHAR(60) NOT NULL,
  tes_id BIGINT UNSIGNED NOT NULL,
  est_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (est_id),
  KEY fk_estado_tipo (tes_id),
  CONSTRAINT fk_estado_tipo FOREIGN KEY (tes_id)
    REFERENCES tipo_estado(tes_id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 6. Create categoria_plato
-- -----------------------------------------------
CREATE TABLE IF NOT EXISTS categoria_plato (
  cat_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  cat_nombre VARCHAR(100) NOT NULL,
  cat_imagen VARCHAR(255) DEFAULT NULL,
  cat_estado TINYINT(1) NOT NULL DEFAULT 1,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (cat_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 7. Recreate plato table
-- -----------------------------------------------
DROP TABLE IF EXISTS plato;
CREATE TABLE plato (
  pla_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  cat_id BIGINT UNSIGNED DEFAULT NULL,
  pla_descripcion VARCHAR(150) NOT NULL,
  pla_codigo VARCHAR(20) DEFAULT NULL,
  pla_precio DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  pla_costo DECIMAL(10,2) DEFAULT NULL,
  pla_imagen VARCHAR(255) DEFAULT NULL,
  est_id BIGINT UNSIGNED NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (pla_id),
  KEY fk_plato_categoria (cat_id),
  KEY fk_plato_estado (est_id),
  CONSTRAINT fk_plato_categoria FOREIGN KEY (cat_id)
    REFERENCES categoria_plato(cat_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_plato_estado FOREIGN KEY (est_id)
    REFERENCES estado(est_id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 8. Recreate pedido table
-- -----------------------------------------------
DROP TABLE IF EXISTS pedido;
CREATE TABLE pedido (
  ped_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  sede_id BIGINT UNSIGNED NOT NULL,
  ped_fecha DATE NOT NULL,
  usu_id BIGINT UNSIGNED NOT NULL,
  mesa_id BIGINT UNSIGNED DEFAULT NULL,
  est_id BIGINT UNSIGNED NOT NULL,
  ped_obs VARCHAR(360) DEFAULT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (ped_id),
  KEY fk_pedido_sede (sede_id),
  KEY fk_pedido_usuario (usu_id),
  KEY fk_pedido_estado (est_id),
  CONSTRAINT fk_pedido_sede FOREIGN KEY (sede_id)
    REFERENCES sede(sede_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_pedido_usuario FOREIGN KEY (usu_id)
    REFERENCES usuario(usu_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_pedido_estado FOREIGN KEY (est_id)
    REFERENCES estado(est_id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 9. Create pedido_detalle
-- -----------------------------------------------
CREATE TABLE IF NOT EXISTS pedido_detalle (
  ped_det_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  ped_id BIGINT UNSIGNED NOT NULL,
  pla_id BIGINT UNSIGNED NOT NULL,
  ped_det_cant SMALLINT UNSIGNED NOT NULL,
  ped_det_precio DECIMAL(10,2) NOT NULL,
  ped_det_obser VARCHAR(255) DEFAULT NULL,
  est_id BIGINT UNSIGNED NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (ped_det_id),
  KEY fk_peddet_pedido (ped_id),
  KEY fk_peddet_plato (pla_id),
  KEY fk_peddet_estado (est_id),
  CONSTRAINT fk_peddet_pedido FOREIGN KEY (ped_id)
    REFERENCES pedido(ped_id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_peddet_plato FOREIGN KEY (pla_id)
    REFERENCES plato(pla_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_peddet_estado FOREIGN KEY (est_id)
    REFERENCES estado(est_id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 10. Recreate forma_pago table
-- -----------------------------------------------
DROP TABLE IF EXISTS forma_pago;
CREATE TABLE forma_pago (
  fp_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  fp_descripcion VARCHAR(60) NOT NULL,
  fp_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (fp_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 11. Recreate cliente table
-- -----------------------------------------------
DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
  cli_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  cli_nombre VARCHAR(60) NOT NULL,
  cli_apellidos VARCHAR(60) NOT NULL,
  cli_tipo_documento VARCHAR(20) NOT NULL,
  cli_num_documento VARCHAR(30) DEFAULT NULL,
  cli_direccion VARCHAR(100) DEFAULT NULL,
  cli_telefono VARCHAR(20) DEFAULT NULL,
  cli_correo VARCHAR(100) DEFAULT NULL,
  cli_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (cli_id),
  UNIQUE KEY uk_cli_num_documento (cli_num_documento),
  UNIQUE KEY uk_cli_correo (cli_correo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 12. Recreate recibo_caja table
-- -----------------------------------------------
DROP TABLE IF EXISTS recibo_caja;
CREATE TABLE recibo_caja (
  rc_num BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  sede_id BIGINT UNSIGNED NOT NULL,
  usu_id BIGINT UNSIGNED NOT NULL,
  rc_fecha DATE NOT NULL,
  ped_id BIGINT UNSIGNED NOT NULL,
  cli_id BIGINT UNSIGNED DEFAULT NULL,
  fp_id BIGINT UNSIGNED NOT NULL,
  rc_subtotal DECIMAL(14,2) NOT NULL,
  rc_descuento DECIMAL(14,2) NOT NULL DEFAULT 0.00,
  rc_propina DECIMAL(14,2) NOT NULL DEFAULT 0.00,
  rc_total DECIMAL(14,2) NOT NULL,
  rc_monto_rec DECIMAL(14,2) DEFAULT NULL,
  rc_cambio DECIMAL(14,2) NOT NULL DEFAULT 0.00,
  rc_observacion VARCHAR(360) DEFAULT NULL,
  rc_estado ENUM('ACTIVO','ANULADO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (rc_num),
  KEY fk_rc_sede (sede_id),
  KEY fk_rc_usuario (usu_id),
  KEY fk_rc_pedido (ped_id),
  KEY fk_rc_cliente (cli_id),
  KEY fk_rc_formapago (fp_id),
  CONSTRAINT fk_rc_sede FOREIGN KEY (sede_id)
    REFERENCES sede(sede_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_rc_usuario FOREIGN KEY (usu_id)
    REFERENCES usuario(usu_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_rc_pedido FOREIGN KEY (ped_id)
    REFERENCES pedido(ped_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_rc_cliente FOREIGN KEY (cli_id)
    REFERENCES cliente(cli_id) ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT fk_rc_formapago FOREIGN KEY (fp_id)
    REFERENCES forma_pago(fp_id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 13. Recreate recibo_caja_detalle table
-- -----------------------------------------------
DROP TABLE IF EXISTS recibo_caja_detalle;
CREATE TABLE recibo_caja_detalle (
  rcd_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  rc_num BIGINT UNSIGNED NOT NULL,
  pla_id BIGINT UNSIGNED NOT NULL,
  rcd_cantidad SMALLINT UNSIGNED NOT NULL,
  rcd_precio DECIMAL(10,2) NOT NULL,
  rcd_descuento DECIMAL(10,2) NOT NULL DEFAULT 0.00,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (rcd_id),
  KEY fk_rcd_recibo (rc_num),
  KEY fk_rcd_plato (pla_id),
  CONSTRAINT fk_rcd_recibo FOREIGN KEY (rc_num)
    REFERENCES recibo_caja(rc_num) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_rcd_plato FOREIGN KEY (pla_id)
    REFERENCES plato(pla_id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 14. Recreate tipo_tpqrs table
-- -----------------------------------------------
DROP TABLE IF EXISTS tipo_tpqrs;
CREATE TABLE tipo_tpqrs (
  tpqrs_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  tpqrs_descripcion VARCHAR(60) NOT NULL,
  tpqrs_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (tpqrs_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 15. Recreate pqrs table
-- -----------------------------------------------
DROP TABLE IF EXISTS pqrs;
CREATE TABLE pqrs (
  pqrs_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  pqrs_fecha DATE NOT NULL,
  pqrs_descripcion TEXT NOT NULL,
  pqrs_correo VARCHAR(100) NOT NULL,
  pqrs_telefono VARCHAR(20) NOT NULL,
  tpqrs_id BIGINT UNSIGNED NOT NULL,
  est_id BIGINT UNSIGNED NOT NULL,
  pqrs_respuesta TEXT DEFAULT NULL,
  usu_id_responde BIGINT UNSIGNED DEFAULT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (pqrs_id),
  KEY fk_pqrs_tipo (tpqrs_id),
  KEY fk_pqrs_estado (est_id),
  KEY fk_pqrs_usuario (usu_id_responde),
  CONSTRAINT fk_pqrs_tipo FOREIGN KEY (tpqrs_id)
    REFERENCES tipo_tpqrs(tpqrs_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_pqrs_estado FOREIGN KEY (est_id)
    REFERENCES estado(est_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_pqrs_usuario FOREIGN KEY (usu_id_responde)
    REFERENCES usuario(usu_id) ON UPDATE CASCADE ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 16. Create concepto_egreso
-- -----------------------------------------------
CREATE TABLE IF NOT EXISTS concepto_egreso (
  con_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  con_descripcion VARCHAR(120) NOT NULL,
  con_estado ENUM('ACTIVO','INACTIVO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (con_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 17. Create encabezado_egresos
-- -----------------------------------------------
CREATE TABLE IF NOT EXISTS encabezado_egresos (
  egr_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  sede_id BIGINT UNSIGNED NOT NULL,
  no_egreso BIGINT UNSIGNED NOT NULL,
  fecha_documento DATE NOT NULL,
  tercero_identificacion VARCHAR(20) NOT NULL,
  tercero_nombre VARCHAR(150) DEFAULT NULL,
  detalle VARCHAR(250) NOT NULL,
  fp_id BIGINT UNSIGNED NOT NULL,
  con_id BIGINT UNSIGNED NOT NULL,
  no_documento VARCHAR(30) NOT NULL,
  valor_egreso DECIMAL(14,2) NOT NULL,
  usu_id BIGINT UNSIGNED NOT NULL,
  egr_estado ENUM('ACTIVO','ANULADO') NOT NULL DEFAULT 'ACTIVO',
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (egr_id),
  UNIQUE KEY uk_no_egreso (no_egreso),
  KEY fk_egreso_sede (sede_id),
  KEY fk_egreso_fp (fp_id),
  KEY fk_egreso_concepto (con_id),
  KEY fk_egreso_usuario (usu_id),
  CONSTRAINT fk_egreso_sede FOREIGN KEY (sede_id)
    REFERENCES sede(sede_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_egreso_fp FOREIGN KEY (fp_id)
    REFERENCES forma_pago(fp_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_egreso_concepto FOREIGN KEY (con_id)
    REFERENCES concepto_egreso(con_id) ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT fk_egreso_usuario FOREIGN KEY (usu_id)
    REFERENCES usuario(usu_id) ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- -----------------------------------------------
-- 18. Create configuracion
-- -----------------------------------------------
CREATE TABLE IF NOT EXISTS configuracion (
  cfg_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  cfg_clave VARCHAR(100) NOT NULL,
  cfg_valor TEXT DEFAULT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (cfg_id),
  UNIQUE KEY uk_cfg_clave (cfg_clave)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

SET FOREIGN_KEY_CHECKS = 1;

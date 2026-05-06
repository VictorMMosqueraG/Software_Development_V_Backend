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

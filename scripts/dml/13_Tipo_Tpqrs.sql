-- Update tipo_tpqrs with estado if not already set
UPDATE tipo_tpqrs SET tpqrs_estado = 'ACTIVO' WHERE tpqrs_estado IS NULL;

-- Insert if empty
INSERT IGNORE INTO tipo_tpqrs (tpqrs_descripcion, tpqrs_estado) VALUES
('Peticion', 'ACTIVO'),
('Queja', 'ACTIVO'),
('Reclamo', 'ACTIVO'),
('Sugerencia', 'ACTIVO');

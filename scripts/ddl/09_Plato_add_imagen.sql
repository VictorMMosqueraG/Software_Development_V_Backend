-- Agregar columna pla_imagen a la tabla plato
ALTER TABLE plato ADD COLUMN pla_imagen VARCHAR(255) NULL AFTER pla_precio;


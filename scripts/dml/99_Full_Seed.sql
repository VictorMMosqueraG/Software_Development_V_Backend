-- ═══════════════════════════════════════════════════════════
-- SEED DATA COMPLETO — Restaurant Management System
-- Ejecutar después de los DDL y seeds básicos
-- ═══════════════════════════════════════════════════════════

SET FOREIGN_KEY_CHECKS = 0;

-- ───────────────────────────────────────────────────────────
-- 1. Completar ESTADOS faltantes (PDF: Comanda, Pedido, Plato, PQRS, Insumo)
-- ───────────────────────────────────────────────────────────
INSERT IGNORE INTO tipo_estado (tes_id, tes_descripcion, tes_estado) VALUES
(4, 'Estado Comanda', 'ACTIVO'),
(5, 'Estado PQRS', 'ACTIVO'),
(6, 'Estado Insumo', 'ACTIVO');

INSERT IGNORE INTO estado (est_id, est_descripcion, tes_id, est_estado) VALUES
-- Comanda (tes_id=4)
(6,  'En Preparacion', 4, 'ACTIVO'),
(7,  'Servido',        4, 'ACTIVO'),
(8,  'Cancelado',      4, 'ACTIVO'),
-- Pedido extras
(9,  'Creado',         1, 'ACTIVO'),
(10, 'Finalizado',     1, 'ACTIVO'),
(11, 'Cancelado',      1, 'ACTIVO'),
-- PQRS (tes_id=5)
(12, 'Pendiente',      5, 'ACTIVO'),
(13, 'Atendida',       5, 'ACTIVO'),
(14, 'Cerrada',        5, 'ACTIVO'),
-- Insumo (tes_id=6)
(15, 'Disponible',     6, 'ACTIVO'),
(16, 'Agotado',        6, 'ACTIVO'),
(17, 'Inactivo',       6, 'ACTIVO');

-- ───────────────────────────────────────────────────────────
-- 2. Más PERFILES
-- ───────────────────────────────────────────────────────────
INSERT IGNORE INTO perfil (perf_id, perf_descripcion, perf_estado) VALUES
(4, 'Cocinero', 'ACTIVO'),
(5, 'Supervisor', 'ACTIVO');

-- ───────────────────────────────────────────────────────────
-- 3. Más USUARIOS
-- ───────────────────────────────────────────────────────────
INSERT IGNORE INTO usuario (usu_id, usu_nombre, usu_apellido, usu_direccion, usu_telefono, usu_correo, perf_id, usu_login, usu_pass, usu_estado) VALUES
(4, 'Maria',   'Lopez',     'Calle 15 # 10-20',  '3004444444', 'maria.lopez@restaurante.com',   4, 'maria.l',  'pass123', 'ACTIVO'),
(5, 'Carlos',  'Ramirez',   'Carrera 7 # 22-30',  '3005555555', 'carlos.ramirez@restaurante.com',2, 'carlos.r', 'pass123', 'ACTIVO'),
(6, 'Ana',     'Martinez',  'Avenida 3 # 5-12',   '3006666666', 'ana.martinez@restaurante.com',  5, 'ana.m',    'pass123', 'ACTIVO'),
(7, 'Diego',   'Hernandez', 'Calle 40 # 8-05',    '3007777777', 'diego.hernandez@restaurante.com',4,'diego.h',  'pass123', 'ACTIVO');

-- ───────────────────────────────────────────────────────────
-- 4. Más CLIENTES
-- ───────────────────────────────────────────────────────────
INSERT IGNORE INTO cliente (cli_id, cli_nombre, cli_apellidos, cli_tipo_documento, cli_num_documento, cli_direccion, cli_telefono, cli_correo, cli_estado) VALUES
(5,  'Sofia',     'Vargas',     'CC',        '1098765432', 'Calle 50 # 12-30',  '3108888888', 'sofia.vargas@email.com',    'ACTIVO'),
(6,  'Andres',    'Castro',     'CC',        '1087654321', 'Carrera 15 # 6-20',  '3109999999', 'andres.castro@email.com',   'ACTIVO'),
(7,  'Valentina', 'Rojas',      'CE',        'E001234567', 'Avenida 68 # 3-45',  '3151111111', 'valentina.rojas@email.com', 'ACTIVO'),
(8,  'Restaurante ABC', 'S.A.S','NIT',       '900123456',  'Zona Industrial',    '6017778899', 'contacto@abc.com',          'ACTIVO'),
(9,  'Camilo',    'Duarte',     'CC',        '1076543210', 'Calle 72 # 11-50',   '3152222222', 'camilo.duarte@email.com',   'ACTIVO'),
(10, 'Isabella',  'Moreno',     'Pasaporte', 'P987654321', 'Hotel Centro',        '3153333333', 'isabella.moreno@email.com', 'ACTIVO');

-- ───────────────────────────────────────────────────────────
-- 5. ÁREAS DE MESA
-- ───────────────────────────────────────────────────────────
INSERT INTO area_mesa (area_id, sede_id, area_nombre, area_estado) VALUES
(1, 1, 'Salón Principal',  'ACTIVO'),
(2, 1, 'Terraza',          'ACTIVO'),
(3, 1, 'Salón VIP',        'ACTIVO'),
(4, 2, 'Salón Principal',  'ACTIVO'),
(5, 2, 'Barra',            'ACTIVO'),
(6, 3, 'Zona Food Court',  'ACTIVO'),
(7, 3, 'Terraza CC',       'ACTIVO');

-- ───────────────────────────────────────────────────────────
-- 6. MESAS
-- ───────────────────────────────────────────────────────────
INSERT INTO mesa (mesa_id, sede_id, area_id, mesa_numero, capacidad, x_pos, y_pos, estado) VALUES
-- Sede 1
(1,  1, 1, 'M-01', 4, 100, 100, 'DISPONIBLE'),
(2,  1, 1, 'M-02', 4, 200, 100, 'DISPONIBLE'),
(3,  1, 1, 'M-03', 6, 300, 100, 'DISPONIBLE'),
(4,  1, 1, 'M-04', 2, 100, 200, 'DISPONIBLE'),
(5,  1, 2, 'T-01', 4, 100, 300, 'DISPONIBLE'),
(6,  1, 2, 'T-02', 6, 200, 300, 'DISPONIBLE'),
(7,  1, 3, 'V-01', 8, 100, 400, 'DISPONIBLE'),
(8,  1, 3, 'V-02', 10,200, 400, 'DISPONIBLE'),
-- Sede 2
(9,  2, 4, 'M-01', 4, 100, 100, 'DISPONIBLE'),
(10, 2, 4, 'M-02', 4, 200, 100, 'DISPONIBLE'),
(11, 2, 4, 'M-03', 6, 300, 100, 'DISPONIBLE'),
(12, 2, 5, 'B-01', 2, 100, 200, 'DISPONIBLE'),
(13, 2, 5, 'B-02', 2, 200, 200, 'DISPONIBLE'),
-- Sede 3
(14, 3, 6, 'F-01', 4, 100, 100, 'DISPONIBLE'),
(15, 3, 6, 'F-02', 4, 200, 100, 'DISPONIBLE'),
(16, 3, 7, 'TC-01',6, 100, 200, 'DISPONIBLE');

-- ───────────────────────────────────────────────────────────
-- 7. Actualizar PLATOS con categoría y más platos
-- ───────────────────────────────────────────────────────────
UPDATE plato SET cat_id = 2 WHERE pla_id IN (1, 3);      -- Platos Fuertes
UPDATE plato SET cat_id = 5 WHERE pla_id IN (2, 4);      -- Sopas
UPDATE plato SET cat_id = 3 WHERE pla_id = 5;             -- Bebidas
UPDATE plato SET pla_costo = pla_precio * 0.35;           -- Costo = 35% del precio

INSERT INTO plato (pla_id, cat_id, pla_descripcion, pla_codigo, pla_precio, pla_costo, est_id) VALUES
(6,  1, 'Empanadas (3 uds)',    'ENT-001', 12000.00, 4200.00,  4),
(7,  1, 'Patacón con Hogao',    'ENT-002', 10000.00, 3500.00,  4),
(8,  2, 'Lomo de Res al Grill', 'PF-001',  35000.00, 12250.00, 4),
(9,  2, 'Trucha al Ajillo',     'PF-002',  30000.00, 10500.00, 4),
(10, 2, 'Pollo a la Plancha',   'PF-003',  22000.00, 7700.00,  4),
(11, 3, 'Jugo de Maracuyá',     'BEB-001', 7000.00,  2450.00,  4),
(12, 3, 'Cerveza Artesanal',    'BEB-002', 12000.00, 4200.00,  4),
(13, 3, 'Agua Mineral',         'BEB-003', 5000.00,  1750.00,  4),
(14, 4, 'Tres Leches',          'POS-001', 10000.00, 3500.00,  4),
(15, 4, 'Brownie con Helado',   'POS-002', 13000.00, 4550.00,  4),
(16, 5, 'Crema de Ahuyama',     'SOP-001', 14000.00, 4900.00,  4),
(17, 1, 'Ceviche de Camarón',   'ENT-003', 18000.00, 6300.00,  4);

-- ───────────────────────────────────────────────────────────
-- 8. CATEGORÍAS DE INSUMO
-- ───────────────────────────────────────────────────────────
INSERT INTO categoria_insumo (cins_id, cins_nombre, cins_estado) VALUES
(1, 'Carnes',          1),
(2, 'Verduras',        1),
(3, 'Lácteos',         1),
(4, 'Granos y Cereales',1),
(5, 'Bebidas Base',    1),
(6, 'Condimentos',     1),
(7, 'Frutas',          1);

-- ───────────────────────────────────────────────────────────
-- 9. INSUMOS
-- ───────────────────────────────────────────────────────────
INSERT INTO insumo (ins_id, sede_id, cins_id, pres_id, ins_nombre, ins_codigo, ins_codigo_barras, ins_precio_compra, ins_stock, ins_stock_min, ins_vendible, ins_estado) VALUES
(1,  1, 1, 1, 'Lomo de Res',       'INS-001', '7701001000011', 28000.00, 25.000,  5.000,  0, 1),
(2,  1, 1, 1, 'Pechuga de Pollo',  'INS-002', '7701001000012', 14000.00, 30.000,  8.000,  0, 1),
(3,  1, 1, 1, 'Trucha Entera',     'INS-003', '7701001000013', 22000.00, 15.000,  3.000,  0, 1),
(4,  1, 2, 1, 'Papa Criolla',      'INS-004', '7701002000014', 3500.00,  50.000,  10.000, 0, 1),
(5,  1, 2, 1, 'Cebolla Cabezona',  'INS-005', '7701002000015', 2800.00,  40.000,  8.000,  0, 1),
(6,  1, 2, 1, 'Tomate',            'INS-006', '7701002000016', 3200.00,  35.000,  7.000,  0, 1),
(7,  1, 2, 3, 'Aguacate Hass',     'INS-007', '7701002000017', 8000.00,  20.000,  5.000,  0, 1),
(8,  1, 3, 2, 'Leche Entera',      'INS-008', '7701003000018', 3800.00,  60.000,  15.000, 0, 1),
(9,  1, 3, 1, 'Queso Doble Crema', 'INS-009', '7701003000019', 16000.00, 10.000,  3.000,  0, 1),
(10, 1, 4, 1, 'Arroz',             'INS-010', '7701004000020', 4200.00,  80.000,  20.000, 0, 1),
(11, 1, 4, 1, 'Frijol Rojo',       'INS-011', '7701004000021', 5500.00,  30.000,  8.000,  0, 1),
(12, 1, 5, 2, 'Jugo de Maracuyá (pulpa)', 'INS-012', '7701005000022', 6000.00, 40.000, 10.000, 0, 1),
(13, 1, 6, 1, 'Sal',               'INS-013', '7701006000023', 1200.00,  15.000,  3.000,  0, 1),
(14, 1, 6, 5, 'Aceite Vegetal',    'INS-014', '7701006000024', 9000.00,  25.000,  5.000,  0, 1),
(15, 1, 7, 1, 'Limón',             'INS-015', '7701007000025', 4000.00,  20.000,  5.000,  0, 1),
-- Sede 2
(16, 2, 1, 1, 'Lomo de Res',       'INS-201', NULL,            28000.00, 18.000,  5.000,  0, 1),
(17, 2, 1, 1, 'Pechuga de Pollo',  'INS-202', NULL,            14000.00, 22.000,  8.000,  0, 1),
(18, 2, 4, 1, 'Arroz',             'INS-203', NULL,            4200.00,  60.000,  20.000, 0, 1);

-- ───────────────────────────────────────────────────────────
-- 10. PLATO INGREDIENTE (Recetas)
-- ───────────────────────────────────────────────────────────
INSERT INTO plato_ingrediente (pla_id, ins_id, pi_cantidad) VALUES
-- Bandeja Paisa (pla_id=1)
(1, 10, 0.200),  -- Arroz 200g
(1, 11, 0.150),  -- Frijol 150g
(1, 1,  0.250),  -- Lomo 250g
(1, 7,  0.100),  -- Aguacate 100g
-- Arroz con Pollo (pla_id=3)
(3, 10, 0.300),  -- Arroz 300g
(3, 2,  0.250),  -- Pollo 250g
(3, 5,  0.050),  -- Cebolla 50g
-- Lomo al Grill (pla_id=8)
(8, 1,  0.350),  -- Lomo 350g
(8, 13, 0.005),  -- Sal 5g
(8, 14, 0.015),  -- Aceite 15ml
-- Limonada (pla_id=5)
(5, 15, 0.100),  -- Limón 100g
-- Jugo Maracuyá (pla_id=11)
(11, 12, 0.200); -- Pulpa 200ml

-- ───────────────────────────────────────────────────────────
-- 11. MOVIMIENTOS DE INVENTARIO
-- ───────────────────────────────────────────────────────────
INSERT INTO inventario_log (ins_id, usu_id, log_tipo, log_cantidad, log_stock_ant, log_stock_nvo, log_nota) VALUES
(1,  1, 'ENTRADA', 30.000, 0.000,   30.000,  'Compra inicial proveedor Carnes del Valle'),
(2,  1, 'ENTRADA', 35.000, 0.000,   35.000,  'Compra inicial proveedor Avícola'),
(10, 1, 'ENTRADA', 100.000,0.000,   100.000, 'Compra de arroz al por mayor'),
(1,  4, 'SALIDA',  5.000,  30.000,  25.000,  'Consumo diario cocina'),
(2,  4, 'SALIDA',  5.000,  35.000,  30.000,  'Consumo diario cocina'),
(10, 4, 'SALIDA',  20.000, 100.000, 80.000,  'Consumo diario cocina'),
(7,  1, 'ENTRADA', 25.000, 0.000,   25.000,  'Compra aguacates frescos'),
(7,  4, 'SALIDA',  5.000,  25.000,  20.000,  'Uso en cocina'),
(8,  1, 'ENTRADA', 80.000, 0.000,   80.000,  'Compra leche del día'),
(8,  4, 'SALIDA',  20.000, 80.000,  60.000,  'Uso en cocina y bebidas'),
(15, 1, 'ENTRADA', 25.000, 0.000,   25.000,  'Compra limones'),
(15, 4, 'MERMA',   5.000,  25.000,  20.000,  'Limones dañados'),
(14, 1, 'ENTRADA', 30.000, 0.000,   30.000,  'Compra aceite vegetal'),
(14, 4, 'SALIDA',  5.000,  30.000,  25.000,  'Consumo cocina');

-- ───────────────────────────────────────────────────────────
-- 12. PEDIDOS
-- ───────────────────────────────────────────────────────────
INSERT INTO pedido (ped_id, sede_id, ped_fecha, usu_id, mesa_id, est_id, ped_obs) VALUES
(1,  1, '2026-05-10', 2, 1,  9,  NULL),
(2,  1, '2026-05-10', 2, 3,  10, NULL),
(3,  1, '2026-05-10', 5, 5,  10, 'Cliente habitual, prefiere sin cebolla'),
(4,  1, '2026-05-11', 2, 2,  9,  NULL),
(5,  1, '2026-05-11', 5, 7,  9,  'Mesa VIP - evento especial'),
(6,  2, '2026-05-11', 5, 9,  9,  NULL),
(7,  2, '2026-05-11', 5, 11, 10, NULL),
(8,  1, '2026-05-11', 2, 4,  11, 'Cancelado por cliente'),
(9,  3, '2026-05-11', 2, 14, 9,  NULL),
(10, 1, '2026-05-11', 5, 6,  10, 'Terraza, buen clima');

-- Marcar mesas como OCUPADA para pedidos activos (est_id=9)
UPDATE mesa SET estado = 'OCUPADA' WHERE mesa_id IN (1, 2, 7, 9, 14);

-- ───────────────────────────────────────────────────────────
-- 13. DETALLE DE PEDIDOS
-- ───────────────────────────────────────────────────────────
INSERT INTO pedido_detalle (ped_id, pla_id, ped_det_cant, ped_det_precio, ped_det_obser, est_id) VALUES
-- Pedido 1
(1, 1,  2, 28000.00, NULL,                6),
(1, 5,  2, 8000.00,  NULL,                7),
(1, 14, 1, 10000.00, 'Sin azúcar extra',  6),
-- Pedido 2 (finalizado)
(2, 8,  1, 35000.00, 'Término medio',     7),
(2, 12, 2, 12000.00, NULL,                7),
(2, 15, 1, 13000.00, NULL,                7),
-- Pedido 3 (finalizado)
(3, 3,  3, 18000.00, 'Sin cebolla',       7),
(3, 11, 3, 7000.00,  NULL,                7),
-- Pedido 4
(4, 6,  2, 12000.00, NULL,                6),
(4, 10, 2, 22000.00, NULL,                6),
(4, 13, 2, 5000.00,  NULL,                7),
-- Pedido 5
(5, 8,  4, 35000.00, 'Todos término 3/4', 6),
(5, 9,  2, 30000.00, NULL,                6),
(5, 17, 4, 18000.00, NULL,                7),
(5, 12, 8, 12000.00, NULL,                7),
-- Pedido 6
(6, 1,  2, 28000.00, NULL,                6),
(6, 16, 2, 14000.00, NULL,                6),
-- Pedido 7 (finalizado)
(7, 10, 3, 22000.00, NULL,                7),
(7, 5,  3, 8000.00,  NULL,                7),
-- Pedido 9
(9, 6,  4, 12000.00, NULL,                6),
(9, 7,  2, 10000.00, NULL,                6),
-- Pedido 10 (finalizado)
(10, 2,  2, 22000.00, NULL,               7),
(10, 11, 2, 7000.00,  NULL,               7);

-- ───────────────────────────────────────────────────────────
-- 14. RESERVACIONES
-- ───────────────────────────────────────────────────────────
INSERT INTO reservacion (sede_id, res_nombre_cli, res_telefono, res_fecha_hora, res_personas, mesa_id, res_nota, res_estado) VALUES
(1, 'Juan Pérez',       '3101234567', '2026-05-12 19:00:00', 4, 3,    'Cumpleaños',                      'CONFIRMADA'),
(1, 'María García',     '3159876543', '2026-05-12 20:00:00', 2, 4,    'Cena romántica',                   'CONFIRMADA'),
(1, 'Empresa XYZ',      '6011234567', '2026-05-13 12:30:00', 8, 8,    'Almuerzo corporativo VIP',         'PENDIENTE'),
(2, 'Carlos Rodríguez', '3181112233', '2026-05-12 18:30:00', 4, 10,   NULL,                               'CONFIRMADA'),
(1, 'Sandra Mejía',     '3204445566', '2026-05-14 13:00:00', 6, NULL,  'Mesa en terraza si hay disponible','PENDIENTE'),
(3, 'Familia Torres',   '3177778899', '2026-05-12 12:00:00', 5, 16,   'Incluye niños, silla alta',        'CONFIRMADA'),
(1, 'Pedro Gómez',      '3001239876', '2026-05-15 20:00:00', 2, NULL,  NULL,                               'PENDIENTE'),
(2, 'Ana López',        '3112345678', '2026-05-11 19:00:00', 3, 12,   NULL,                               'CANCELADA');

-- Marcar mesas reservadas
UPDATE mesa SET estado = 'RESERVADA' WHERE mesa_id IN (3, 4, 10, 16);

-- ───────────────────────────────────────────────────────────
-- 15. RECIBOS DE CAJA (pedidos finalizados)
-- ───────────────────────────────────────────────────────────
INSERT INTO recibo_caja (rc_num, sede_id, usu_id, rc_fecha, ped_id, cli_id, fp_id, rc_subtotal, rc_descuento, rc_propina, rc_total, rc_monto_rec, rc_cambio, rc_observacion, rc_estado) VALUES
(1, 1, 3, '2026-05-10', 2, 5,    1, 72000.00, 0.00,     7200.00,  79200.00,  80000.00, 800.00,   NULL,                     'ACTIVO'),
(2, 1, 3, '2026-05-10', 3, 6,    2, 75000.00, 5000.00,  7000.00,  77000.00,  NULL,     0.00,     'Transferencia Nequi',     'ACTIVO'),
(3, 2, 3, '2026-05-11', 7, NULL,  1, 90000.00, 0.00,     9000.00,  99000.00,  100000.00,1000.00,  'Público general',         'ACTIVO'),
(4, 1, 3, '2026-05-11', 10,9,    3, 58000.00, 3000.00,  5500.00,  60500.00,  NULL,     0.00,     'Pago con tarjeta débito', 'ACTIVO');

-- ───────────────────────────────────────────────────────────
-- 16. DETALLE RECIBOS DE CAJA
-- ───────────────────────────────────────────────────────────
INSERT INTO recibo_caja_detalle (rc_num, pla_id, rcd_cantidad, rcd_precio, rcd_descuento) VALUES
-- Recibo 1 (pedido 2)
(1, 8,  1, 35000.00, 0.00),
(1, 12, 2, 12000.00, 0.00),
(1, 15, 1, 13000.00, 0.00),
-- Recibo 2 (pedido 3)
(2, 3,  3, 18000.00, 3000.00),
(2, 11, 3, 7000.00,  2000.00),
-- Recibo 3 (pedido 7)
(3, 10, 3, 22000.00, 0.00),
(3, 5,  3, 8000.00,  0.00),
-- Recibo 4 (pedido 10)
(4, 2,  2, 22000.00, 2000.00),
(4, 11, 2, 7000.00,  1000.00);

-- ───────────────────────────────────────────────────────────
-- 17. EGRESOS
-- ───────────────────────────────────────────────────────────
INSERT INTO encabezado_egresos (sede_id, no_egreso, fecha_documento, tercero_identificacion, tercero_nombre, detalle, fp_id, con_id, no_documento, valor_egreso, usu_id, egr_estado) VALUES
(1, 1001, '2026-05-10', '900111222',  'Carnes del Valle SAS',     'Compra de carnes para la semana',          1, 4, 'FAC-2890',  840000.00,  1, 'ACTIVO'),
(1, 1002, '2026-05-10', '900333444',  'Distribuidora Avícola',    'Compra de pollos y huevos',                2, 4, 'FAC-1456',  490000.00,  1, 'ACTIVO'),
(1, 1003, '2026-05-11', '800555666',  'EPM',                      'Factura servicios públicos mayo',          2, 2, 'SER-05-26', 1250000.00, 1, 'ACTIVO'),
(1, 1004, '2026-05-11', '1098765432', 'Sofia Vargas',             'Nómina quincenal meseros',                 2, 3, 'NOM-Q1-05', 3200000.00, 1, 'ACTIVO'),
(2, 2001, '2026-05-11', '900777888',  'Frutas Frescas Ltda',      'Compra de frutas y verduras',              1, 4, 'FAC-0789',  380000.00,  1, 'ACTIVO'),
(1, 1005, '2026-05-11', '900999000',  'Técnicos del Frío SAS',    'Mantenimiento nevera industrial',          1, 5, 'SER-0234',  450000.00,  1, 'ACTIVO'),
(2, 2002, '2026-05-10', '900111222',  'Carnes del Valle SAS',     'Compra de carnes sede norte',              1, 4, 'FAC-2891',  560000.00,  1, 'ACTIVO'),
(1, 1006, '2026-05-09', '800123456',  'Proveedor cancelado',      'Compra devuelta',                          1, 4, 'FAC-0001',  150000.00,  1, 'ANULADO');

-- ───────────────────────────────────────────────────────────
-- 18. PQRS
-- ───────────────────────────────────────────────────────────
INSERT INTO pqrs (pqrs_fecha, pqrs_descripcion, pqrs_correo, pqrs_telefono, tpqrs_id, est_id, pqrs_respuesta, usu_id_responde) VALUES
('2026-05-10', 'El servicio fue excelente pero la demora en la cocina fue considerable. Esperamos más de 40 minutos por los platos fuertes.',
 'sofia.vargas@email.com', '3108888888', 2, 13, 'Agradecemos su comentario. Hemos reforzado el personal de cocina en horas pico para reducir tiempos de espera.', 1),

('2026-05-11', 'Quisiera saber si tienen menú para personas con restricciones alimentarias (celíacos, vegetarianos).',
 'camilo.duarte@email.com', '3152222222', 1, 12, NULL, NULL),

('2026-05-11', 'Encontramos un cabello en la sopa del día. Es inaceptable para un restaurante de este nivel.',
 'isabella.moreno@email.com', '3153333333', 3, 13, 'Lamentamos profundamente lo ocurrido. Se ha reforzado el protocolo de higiene y ofrecemos una cena de cortesía.', 6),

('2026-05-09', 'Sugiero agregar más opciones de postres y ampliar el horario de terraza los fines de semana.',
 'andres.castro@email.com', '3109999999', 4, 14, 'Gracias por su sugerencia, la terraza ya opera hasta las 11pm viernes y sábados. Nuevos postres próximamente.', 1),

('2026-05-11', 'El mesero Pedro fue muy amable y atento. Excelente atención, felicitaciones.',
 'valentina.rojas@email.com', '3151111111', 4, 14, 'Agradecemos sus palabras, serán transmitidas al equipo.', 6),

('2026-05-11', 'Se cobró un plato que no pedimos en la cuenta. Pedimos corrección.',
 'contacto@abc.com', '6017778899', 3, 12, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;

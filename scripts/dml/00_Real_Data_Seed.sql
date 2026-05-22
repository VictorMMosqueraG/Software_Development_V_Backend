SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM recibo_caja_detalle;
DELETE FROM recibo_caja;
DELETE FROM pqrs;
DELETE FROM comanda;
DELETE FROM pedido_detalle;
DELETE FROM pedido;
DELETE FROM plato;
DELETE FROM usuario;
DELETE FROM cliente;
DELETE FROM encabezado_egresos;
DELETE FROM concepto;
DELETE FROM forma_pago;
DELETE FROM estado;
DELETE FROM tipo_tpqrs;
DELETE FROM tipo_estado;
DELETE FROM perfil;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO perfil (perf_id, perf_descripcion, perf_estado) VALUES
(1, 'Administrador', 'Activo'),
(2, 'Mesero', 'Activo'),
(3, 'Cajero', 'Activo');

INSERT INTO tipo_estado (tes_id, tes_descripcion, tes_estado) VALUES
(1, 'Peticion', 'Activo'),
(2, 'Pedido', 'Activo'),
(3, 'Plato', 'Activo'),
(4, 'PQRS', 'Activo');

INSERT INTO tipo_tpqrs (tpqrs_id, tpqrs_descripcion, tpqrs_estado) VALUES
(1, 'Peticion', 'Activo'),
(2, 'Queja', 'Activo'),
(3, 'Reclamo', 'Activo'),
(4, 'Sugerencia', 'Activo');

INSERT INTO estado (est_id, est_descripcion, tes_id, est_estado) VALUES
(1, 'En Preparación', 1, 'Activo'),
(2, 'Finalizada', 1, 'Activo'),
(3, 'Cancelada', 1, 'Activo'),
(4, 'Creado', 2, 'Activo'),
(5, 'Finalizado', 2, 'Activo'),
(6, 'Cancelado', 2, 'Activo'),
(7, 'Creado', 3, 'Activo'),
(8, 'Disponible', 3, 'Activo'),
(9, 'Inactivo', 3, 'Activo'),
(10, 'Agotado', 3, 'Activo'),
(11, 'Pendiente', 4, 'Activo'),
(12, 'Atendida', 4, 'Activo');

INSERT INTO forma_pago (fp_id, fp_descripcion, fp_estado) VALUES
(1, 'Efectivo', 'Activo'),
(2, 'Transferencia', 'Activo');

INSERT INTO concepto (con_id, con_descripcion, con_estado) VALUES
(1, 'Pago a terceros', 'Activo'),
(2, 'Pago a Servicios Públicos', 'Activo'),
(3, 'Pago a Nómina', 'Activo');

INSERT INTO cliente (cli_id, cli_nombre, cli_apellidos, cli_direccion, cli_telefono, cli_correo, cli_estado, cli_num_documento, cli_tipo_documento) VALUES
(1, 'Juan Jose', 'Canizalez Velarde', 'Cra 2c # 23-68', '3104321486', 'jcanizalez@gmail.com', 'Activo', '1000000001', 'CC'),
(2, 'Juan', 'Galvis Osorio', 'Cra 26P #44-42', '3157621528', 'galvis520@gmail.com', 'Activo', '1000000002', 'CC'),
(3, 'Juan', 'Dineno', 'Ave 5 # 10-20', '4445566', 'dineg@hotmail.com', 'InActivo', '1000000003', 'TI'),
(4, 'María', 'Lopez Torres', 'Carrera 15 # 8-45', '3109876543', 'maria.lopez@email.com', 'Activo', '1000000004', 'CC'),
(5, 'Carlos', 'Ramirez Diaz', 'Avenida 6 # 12-30', '3204567890', 'carlos.ramirez@email.com', 'Activo', '1000000005', 'CC');

INSERT INTO usuario (usu_id, usu_nombre, usu_apellido, usu_direccion, usu_telefono, usu_correo, perf_id, usu_login, usu_pass, usu_estado) VALUES
(1234, 'Admin', '', 'Calle Principal # 1-01', '3001111111', 'admin@restaurante.com', 1, 'admin', '1234', 'Activo'),
(1144156104, 'Juan Manuel', 'Galvis Osorio', 'Cra 26P #44-42', '3157621587', 'galvis520@gmail.com', 2, 'galvis520', '1234', 'Activo'),
(2001, 'Pedro', 'Gutiérrez', 'Calle 8 # 7-15', '3002222222', 'pedro.gutierrez@restaurante.com', 2, 'pedro.g', 'pass123', 'Activo'),
(2002, 'Laura', 'Sánchez', 'Carrera 14 # 3-10', '3003333333', 'laura.sanchez@restaurante.com', 3, 'laura.s', 'pass123', 'Activo');

INSERT INTO plato (pla_id, pla_descripcion, pla_precio, pla_imagen, est_id) VALUES
(1, 'Bandeja Paisa', 10000, NULL, 8),
(2, 'Ajiaco', 10000, NULL, 8),
(3, 'Consomé', 4000, NULL, 8),
(4, 'Arroz Mixto', 12000, NULL, 8),
(5, 'Limonada Natural', 10, 'http://localhost:8080/uploads/platos/e5c4cb54-650d-4670-b897-5452d240125d.png', 8);

INSERT INTO pedido (ped_id, ped_fecha, usu_id, ped_mesa, est_id) VALUES
(21, '2026-03-11', 1234, '1', 5),
(22, '2026-03-11', 1234, '1', 5),
(23, '2026-03-11', 1234, '2', 5),
(24, '2026-03-11', 1234, '2', 5),
(25, '2026-03-11', 1234, '3', 5),
(26, '2026-03-11', 1234, '3', 4),
(27, '2026-05-19', 1144156104, '1', 5),
(28, '2026-05-19', 1144156104, '4', 6);

INSERT INTO pedido_detalle (ped_det_id, ped_det_cant, ped_det_precio, ped_det_obser, pla_id, ped_id, est_id) VALUES
(25, 2, 10000, 'Sin observaciones', 1, 21, 1),
(26, 1, 10000, 'Sin observaciones', 1, 22, 1),
(27, 1, 10000, 'Sin observaciones', 1, 23, 1),
(28, 1, 10000, 'Sin observaciones', 1, 24, 1),
(29, 1, 10000, 'Sin observaciones', 2, 24, 1),
(30, 1, 4000, 'Sin observaciones', 3, 24, 1),
(31, 1, 12000, 'Sin observaciones', 4, 24, 1),
(32, 1, 10000, 'Sin observaciones', 1, 25, 1),
(33, 1, 10000, 'Sin observaciones', 2, 25, 1),
(34, 1, 4000, 'Sin observaciones', 3, 25, 1),
(35, 1, 10000, 'Sin observaciones', 1, 26, 1),
(36, 1, 10000, 'Sin observaciones', 1, 27, 1),
(37, 1, 10000, 'Sin observaciones', 2, 28, 1),
(38, 1, 4000, 'Sin observaciones', 3, 28, 1);

INSERT INTO comanda (com_id, mesa, pla_id, com_obs, est_id) VALUES
(21, 1, 1, 'Sin observaciones', 3),
(22, 1, 1, 'Sin observaciones', 3),
(23, 1, 1, 'Sin observaciones', 3),
(24, 1, 2, 'Sin observaciones', 3),
(25, 1, 3, 'Sin observaciones', 3),
(26, 1, 4, 'Sin observaciones', 3),
(27, 2, 1, 'Sin observaciones', 1),
(28, 2, 2, 'Sin observaciones', 2),
(29, 2, 3, 'Sin observaciones', 1),
(30, 3, 1, 'Sin observaciones', 2),
(31, 1, 1, 'Sin observaciones', 1),
(32, 4, 2, 'Sin observaciones', 1),
(33, 4, 3, 'Sin observaciones', 1);

INSERT INTO pqrs (pqrs_id, pqrs_fecha, pqrs_descripcion, pqrs_correo, pqrs_telefono, tpqrs_id, est_id, pqrs_respuesta) VALUES
(1, '2026-05-01', 'La atención fue excelente, solo sugerimos más opciones de bebidas.', 'jcanizalez@gmail.com', '3104321486', 4, 12, 'Gracias por su comentario, lo tendremos en cuenta.'),
(2, '2026-05-03', 'El pedido tardó un poco más de lo esperado.', 'galvis520@gmail.com', '3157621528', 2, 11, 'Estamos revisando el caso con operación.'),
(3, '2026-05-05', 'Deseo felicitar al personal por la amabilidad.', 'maria.lopez@email.com', '3109876543', 1, 12, 'Agradecemos su reconocimiento.'),
(4, '2026-05-10', 'Solicito información sobre ingredientes del plato del día.', 'carlos.ramirez@email.com', '3204567890', 1, 11, 'Se responderá a la brevedad.' );

INSERT INTO recibo_caja (rc_num, usu_id, rc_fecha, ped_id, cli_id, rc_total, rc_observacion, rc_estado) VALUES
(1, 1234, '2026-03-11', 21, 1, 20000, 'Pago en efectivo', 'Activo'),
(2, 1234, '2026-03-11', 22, 2, 20000, 'Pago en efectivo', 'Activo'),
(3, 1234, '2026-03-11', 23, 3, 24000, 'Pago en efectivo', 'Activo'),
(4, 1234, '2026-03-11', 24, 4, 32000, 'Transferencia aprobada', 'Activo'),
(5, 1144156104, '2026-05-19', 25, 5, 18000, 'Pago en efectivo', 'Activo'),
(6, 1144156104, '2026-05-19', 27, 1, 12010, 'Propina incluida', 'Activo');

INSERT INTO recibo_caja_detalle (rcd_id, rcd_num, pla_id, rcd_precio, rcd_cantidad) VALUES
(1, 1, 1, 10000, 2),
(2, 2, 1, 10000, 1),
(3, 2, 2, 10000, 1),
(4, 3, 1, 10000, 2),
(5, 3, 3, 4000, 1),
(6, 4, 2, 10000, 2),
(7, 4, 4, 12000, 1),
(8, 5, 3, 4000, 2),
(9, 5, 2, 10000, 1),
(10, 6, 4, 12000, 1),
(11, 6, 5, 10, 1);

INSERT INTO encabezado_egresos (id, no_egreso, fecha_documento, tercero_identificacion, detalle, fp_id, conceptoEgreso_codigo, no_documento, valor_egreso, estado) VALUES
(1, 9001, '2026-05-01 08:00:00', '900123456', 'Compra de insumos para cocina', 1, 1, 'OC-001', 250000, 'ACTIVO'),
(2, 9002, '2026-05-08 09:15:00', '800987654', 'Pago de servicios públicos', 2, 2, 'SP-014', 180000, 'ACTIVO'),
(3, 9003, '2026-05-15 07:30:00', '700555444', 'Pago de nómina', 1, 3, 'NM-021', 1200000, 'ACTIVO');

-- Datos adicionales para aumentar el volumen y mantener relaciones coherentes

INSERT INTO cliente (cli_id, cli_nombre, cli_apellidos, cli_direccion, cli_telefono, cli_correo, cli_estado, cli_num_documento, cli_tipo_documento) VALUES
(6, 'Ana', 'Lopez Mejia', 'Calle 12 # 9-34', '3011112222', 'ana.lopez@email.com', 'Activo', '1000000006', 'CC'),
(7, 'Diego', 'Torres Mora', 'Carrera 7 # 18-09', '3012223333', 'diego.torres@email.com', 'Activo', '1000000007', 'CC'),
(8, 'Sofía', 'Rojas Peña', 'Avenida 3 # 22-11', '3013334444', 'sofia.rojas@email.com', 'Activo', '1000000008', 'TI'),
(9, 'Camilo', 'Herrera Gil', 'Diagonal 15 # 4-55', '3014445555', 'camilo.herrera@email.com', 'Activo', '1000000009', 'CC'),
(10, 'Valentina', 'Castro Ruiz', 'Carrera 10 # 6-20', '3015556666', 'valentina.castro@email.com', 'Activo', '1000000010', 'CC');

INSERT INTO usuario (usu_id, usu_nombre, usu_apellido, usu_direccion, usu_telefono, usu_correo, perf_id, usu_login, usu_pass, usu_estado) VALUES
(2003, 'Oscar', 'Medina', 'Carrera 18 # 10-22', '3004444444', 'oscar.medina@restaurante.com', 2, 'oscar.m', 'pass123', 'Activo'),
(2004, 'Natalia', 'Prieto', 'Calle 30 # 5-40', '3005555555', 'natalia.prieto@restaurante.com', 2, 'natalia.p', 'pass123', 'Activo'),
(2005, 'Andrés', 'Lozano', 'Carrera 5 # 1-18', '3006666666', 'andres.lozano@restaurante.com', 3, 'andres.l', 'pass123', 'Activo');

INSERT INTO plato (pla_id, pla_descripcion, pla_precio, pla_imagen, est_id) VALUES
(6, 'Chuleta Valluna', 24000, NULL, 8),
(7, 'Posta Cartagenera', 26000, NULL, 8),
(8, 'Mojarra Frita', 28000, NULL, 8),
(9, 'Patacón con Hogao', 9000, NULL, 8),
(10, 'Chocolate Caliente', 6000, NULL, 8),
(11, 'Ensalada de la Casa', 7000, NULL, 8),
(12, 'Tinto', 3000, NULL, 8);

INSERT INTO pedido (ped_id, ped_fecha, usu_id, ped_mesa, est_id) VALUES
(29, '2026-05-20', 2003, '6', 5),
(30, '2026-05-20', 2004, '7', 5),
(31, '2026-05-20', 2003, '8', 4),
(32, '2026-05-20', 2004, '9', 5),
(33, '2026-05-20', 1234, '10', 5),
(34, '2026-05-21', 2003, '11', 6),
(35, '2026-05-21', 2004, '12', 5),
(36, '2026-05-21', 2003, '13', 5),
(37, '2026-05-21', 2004, '14', 4),
(38, '2026-05-21', 1234, '15', 5),
(39, '2026-05-22', 2003, '16', 5),
(40, '2026-05-22', 2004, '17', 5);

INSERT INTO pedido_detalle (ped_det_id, ped_det_cant, ped_det_precio, ped_det_obser, pla_id, ped_id, est_id) VALUES
(39, 2, 10000, 'Sin observaciones', 1, 29, 1),
(40, 2, 6000, 'Bebidas extra', 10, 29, 1),
(41, 1, 7000, 'Sin observaciones', 11, 29, 1),
(42, 1, 10000, 'Sin observaciones', 2, 30, 1),
(43, 1, 12000, 'Sin observaciones', 4, 30, 1),
(44, 2, 3000, 'Sin observaciones', 12, 30, 1),
(45, 2, 4000, 'Sin observaciones', 3, 31, 1),
(46, 2, 9000, 'Sin observaciones', 9, 31, 1),
(47, 3, 10000, 'Mesa llena', 1, 32, 1),
(48, 1, 24000, 'Sin observaciones', 6, 32, 1),
(49, 2, 10000, 'Sin observaciones', 2, 33, 1),
(50, 1, 26000, 'Sin observaciones', 7, 33, 1),
(51, 1, 6000, 'Sin observaciones', 10, 33, 1),
(52, 1, 12000, 'Pedido anulado por cliente', 4, 34, 1),
(53, 1, 28000, 'Sin observaciones', 8, 35, 1),
(54, 1, 7000, 'Sin observaciones', 11, 35, 1),
(55, 1, 10000, 'Sin observaciones', 2, 36, 1),
(56, 1, 4000, 'Sin observaciones', 3, 36, 1),
(57, 2, 9000, 'Sin observaciones', 9, 36, 1),
(58, 3, 3000, 'Sin observaciones', 12, 36, 1),
(59, 2, 12000, 'Sin observaciones', 4, 37, 1),
(60, 1, 24000, 'Sin observaciones', 6, 37, 1),
(61, 2, 10000, 'Sin observaciones', 1, 38, 1),
(62, 1, 26000, 'Sin observaciones', 7, 38, 1),
(63, 1, 6000, 'Sin observaciones', 10, 38, 1),
(64, 3, 10000, 'Sin observaciones', 2, 39, 1),
(65, 1, 7000, 'Sin observaciones', 11, 39, 1),
(66, 2, 10000, 'Sin observaciones', 1, 40, 1),
(67, 1, 24000, 'Sin observaciones', 6, 40, 1),
(68, 1, 9000, 'Sin observaciones', 9, 40, 1),
(69, 2, 3000, 'Sin observaciones', 12, 40, 1);

INSERT INTO comanda (com_id, mesa, pla_id, com_obs, est_id) VALUES
(34, 6, 1, 'Mesa 6 solicita refuerzo', 1),
(35, 7, 2, 'Sin observaciones', 2),
(36, 8, 3, 'Sin observaciones', 1),
(37, 9, 4, 'Mesa 9 para finalizar', 2),
(38, 10, 6, 'Sin observaciones', 3),
(39, 11, 7, 'Sin observaciones', 1),
(40, 12, 8, 'Sin observaciones', 2),
(41, 13, 9, 'Sin observaciones', 1),
(42, 14, 10, 'Mesa 14 solicita más hielo', 1),
(43, 15, 11, 'Sin observaciones', 2),
(44, 16, 12, 'Sin observaciones', 1),
(45, 17, 1, 'Sin observaciones', 3);

INSERT INTO pqrs (pqrs_id, pqrs_fecha, pqrs_descripcion, pqrs_correo, pqrs_telefono, tpqrs_id, est_id, pqrs_respuesta) VALUES
(5, '2026-05-11', 'La comida llegó caliente y en buen tiempo.', 'ana.lopez@email.com', '3011112222', 4, 12, 'Gracias por su comentario.'),
(6, '2026-05-12', 'Solicito cambio en la bebida del combo.', 'diego.torres@email.com', '3012223333', 1, 11, 'Solicitud recibida y en revisión.'),
(7, '2026-05-13', 'Hubo demora en la atención de la mesa 7.', 'sofia.rojas@email.com', '3013334444', 2, 11, 'Se hace seguimiento al caso.'),
(8, '2026-05-14', 'Felicitaciones por la sazón de la mojarra.', 'camilo.herrera@email.com', '3014445555', 4, 12, 'Gracias por preferirnos.' );

INSERT INTO recibo_caja (rc_num, usu_id, rc_fecha, ped_id, cli_id, rc_total, rc_observacion, rc_estado) VALUES
(7, 2005, '2026-05-20', 29, 6, 45000, 'Pago en efectivo', 'Activo'),
(8, 2005, '2026-05-20', 30, 7, 28000, 'Pago con tarjeta', 'Activo'),
(9, 2005, '2026-05-20', 32, 8, 54000, 'Pago en efectivo', 'Activo'),
(10, 2005, '2026-05-20', 33, 9, 52000, 'Transferencia', 'Activo'),
(11, 2005, '2026-05-21', 35, 10, 73000, 'Pago en efectivo', 'Activo'),
(12, 2005, '2026-05-21', 36, 1, 41000, 'Pago en efectivo', 'Activo'),
(13, 2005, '2026-05-21', 38, 2, 52000, 'Pago en efectivo', 'Activo'),
(14, 2005, '2026-05-22', 39, 3, 37000, 'Pago con tarjeta', 'Activo'),
(15, 2005, '2026-05-22', 40, 4, 49000, 'Pago en efectivo', 'Activo');

INSERT INTO recibo_caja_detalle (rcd_id, rcd_num, pla_id, rcd_precio, rcd_cantidad) VALUES
(12, 7, 1, 10000, 2),
(13, 7, 10, 6000, 2),
(14, 7, 11, 7000, 1),
(15, 7, 12, 3000, 2),
(16, 8, 2, 10000, 1),
(17, 8, 4, 12000, 1),
(18, 8, 12, 3000, 2),
(19, 9, 1, 10000, 3),
(20, 9, 6, 24000, 1),
(21, 10, 2, 10000, 2),
(22, 10, 7, 26000, 1),
(23, 10, 10, 6000, 1),
(24, 11, 1, 10000, 1),
(25, 11, 8, 28000, 2),
(26, 11, 11, 7000, 1),
(27, 12, 2, 10000, 1),
(28, 12, 3, 4000, 1),
(29, 12, 9, 9000, 2),
(30, 12, 12, 3000, 3),
(31, 13, 1, 10000, 2),
(32, 13, 7, 26000, 1),
(33, 13, 10, 6000, 1),
(34, 14, 2, 10000, 3),
(35, 14, 11, 7000, 1),
(36, 15, 1, 10000, 2),
(37, 15, 6, 24000, 1),
(38, 15, 9, 9000, 1),
(39, 15, 12, 3000, 2);

INSERT INTO encabezado_egresos (id, no_egreso, fecha_documento, tercero_identificacion, detalle, fp_id, conceptoEgreso_codigo, no_documento, valor_egreso, estado) VALUES
(4, 9004, '2026-05-18 08:20:00', '701112223', 'Compra de frutas y verduras', 1, 1, 'OC-002', 320000, 'ACTIVO'),
(5, 9005, '2026-05-19 09:40:00', '702223334', 'Servicio de mantenimiento de cocina', 2, 2, 'SP-015', 145000, 'ACTIVO'),
(6, 9006, '2026-05-20 07:15:00', '703334445', 'Pago adicional de nómina', 1, 3, 'NM-022', 980000, 'ACTIVO');

SET FOREIGN_KEY_CHECKS = 1;


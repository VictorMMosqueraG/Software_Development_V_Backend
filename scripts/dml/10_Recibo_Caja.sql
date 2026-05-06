-- Requiere: sede, usuario, pedido, cliente, forma_pago ya insertados
INSERT INTO recibo_caja (sede_id, usu_id, rc_fecha, ped_id, cli_id, fp_id, rc_subtotal, rc_descuento, rc_propina, rc_total, rc_monto_rec, rc_cambio, rc_observacion, rc_estado) VALUES
(1, 1234, '2026-03-10', 1, 1, 1, 45000.00, 0.00, 5000.00, 50000.00, 50000.00, 0.00, 'Pago exacto en efectivo', 'ACTIVO'),
(1, 1234, '2026-03-10', 2, 2, 3, 32000.00, 2000.00, 0.00, 30000.00, 30000.00, 0.00, 'Pago con tarjeta debito', 'ACTIVO'),
(1, 1234, '2026-03-11', 3, NULL, 1, 85000.00, 5000.00, 8000.00, 88000.00, 100000.00, 12000.00, 'Publico general - efectivo', 'ACTIVO'),
(1, 1234, '2026-03-12', 4, 3, 4, 120000.00, 10000.00, 12000.00, 122000.00, NULL, 0.00, 'Pago con tarjeta credito', 'ACTIVO'),
(1, 1234, '2026-03-12', 5, 1, 2, 55000.00, 0.00, 5500.00, 60500.00, 60500.00, 0.00, 'Transferencia bancaria', 'ANULADO');

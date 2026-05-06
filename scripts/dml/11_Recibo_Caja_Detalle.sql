-- Requiere: recibo_caja y plato ya insertados
-- Usa pla_id de los platos existentes en la tabla plato
INSERT INTO recibo_caja_detalle (rc_num, pla_id, rcd_cantidad, rcd_precio, rcd_descuento) VALUES
-- Recibo 1: dos platos
(1, 1, 2, 15000.00, 0.00),
(1, 2, 1, 15000.00, 0.00),
-- Recibo 2: un plato
(2, 1, 2, 16000.00, 0.00),
-- Recibo 3: tres platos
(3, 1, 3, 15000.00, 0.00),
(3, 2, 2, 12500.00, 0.00),
(3, 3, 1, 15000.00, 0.00),
-- Recibo 4: pedido grande
(4, 1, 4, 15000.00, 2500.00),
(4, 2, 4, 15000.00, 2500.00),
-- Recibo 5 (anulado): un plato
(5, 1, 2, 15000.00, 0.00),
(5, 3, 1, 25000.00, 0.00);

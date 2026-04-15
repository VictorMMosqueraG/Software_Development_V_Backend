package development.v.development.application.features.Order.CreateOrder;

import org.springframework.stereotype.Service;

import development.v.development.application.features.Order.CreateOrder.Dtos.CreateOrderDetailDto;
import development.v.development.application.features.Order.CreateOrder.Dtos.CreateOrderRequestDto;
import development.v.development.application.features.Order.CreateOrder.Mappers.CreateOrderMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.Command;
import development.v.development.domain.models.Order;
import development.v.development.domain.models.OrderDetail;
import development.v.development.domain.repositories.CommandRepository;
import development.v.development.domain.repositories.OrderDetailRepository;
import development.v.development.domain.repositories.OrderRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreateOrderUseCase {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CommandRepository commandRepository;

    public CreateOrderUseCase(
            OrderRepository orderRepository,
            OrderDetailRepository orderDetailRepository,
            CommandRepository commandRepository) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.commandRepository = commandRepository;
    }

    public DataResultDto<Order> execute(CreateOrderRequestDto request) {
        // 1. Crear el pedido
        Order domain = CreateOrderMapper.toDomain(request);
        Order savedOrder = orderRepository.save(domain);

        // 2. Crear los detalles del pedido y las comandas para cocina
        for (CreateOrderDetailDto detalle : request.getDetalles()) {
            // Crear detalle del pedido
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPedId(savedOrder.getPedId());
            orderDetail.setPlaId(detalle.getPlaId());
            orderDetail.setPedDetCant(detalle.getCantidad());
            orderDetail.setPedDetPrecio(detalle.getPrecio());
            orderDetail.setPedDetObser(detalle.getObservacion());
            orderDetail.setEstId(1); // Estado: En Preparacion
            orderDetailRepository.save(orderDetail);

            // Crear comanda para cocina
            Command command = new Command();
            command.setMesa(Integer.parseInt(savedOrder.getPedMesa()));
            command.setPlaId(detalle.getPlaId());
            command.setComObs(detalle.getObservacion() != null ? detalle.getObservacion() : "");
            command.setEstId(1); // Estado: En Preparacion
            commandRepository.save(command);
        }

        return DataResultDto.success(savedOrder, Message.CREATED);
    }
}


package development.v.development.infrastruture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.domain.models.FormaPago;
import development.v.development.domain.models.Order;
import development.v.development.domain.models.Sede;
import development.v.development.domain.models.User;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.infrastruture.entities.PlatoEntity;
import development.v.development.infrastruture.mappers.FormaPagoMapper;
import development.v.development.infrastruture.mappers.OrderMapper;
import development.v.development.infrastruture.mappers.SedeMapper;
import development.v.development.infrastruture.mappers.UserMapper;
import development.v.development.infrastruture.repositories.CashReceipt.CashReceipJpaRepository;
import development.v.development.infrastruture.repositories.FormaPago.FormaPagoJpaRepository;
import development.v.development.infrastruture.repositories.Order.OrderJpaRepository;
import development.v.development.infrastruture.repositories.Plato.PlatoJpaRepository;
import development.v.development.infrastruture.repositories.Sede.SedeJpaRepository;
import development.v.development.infrastruture.repositories.User.UserJpaRepository;
import development.v.development.infrastruture.mappers.CashReceiptMapper;
import development.v.development.domain.models.CashReceipt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/lookup")
@Tag(name = "Lookup", description = "Listas auxiliares para formularios")
public class LookupController {

    private final SedeJpaRepository sedeRepo;
    private final UserJpaRepository userRepo;
    private final OrderJpaRepository orderRepo;
    private final FormaPagoJpaRepository formaPagoRepo;
    private final PlatoJpaRepository platoRepo;
    private final CashReceipJpaRepository cashReceiptRepo;

    public LookupController(
            SedeJpaRepository sedeRepo,
            UserJpaRepository userRepo,
            OrderJpaRepository orderRepo,
            FormaPagoJpaRepository formaPagoRepo,
            PlatoJpaRepository platoRepo,
            CashReceipJpaRepository cashReceiptRepo) {
        this.sedeRepo = sedeRepo;
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
        this.formaPagoRepo = formaPagoRepo;
        this.platoRepo = platoRepo;
        this.cashReceiptRepo = cashReceiptRepo;
    }

    @Operation(summary = "Listar sedes")
    @GetMapping("/sedes")
    public ResponseEntity<DataResultDto<List<Sede>>> getSedes() {
        List<Sede> data = sedeRepo.findAll().stream()
                .map(SedeMapper::toDomain).collect(Collectors.toList());
        return ResponseEntity.ok(DataResultDto.success(data));
    }

    @Operation(summary = "Listar usuarios")
    @GetMapping("/usuarios")
    public ResponseEntity<DataResultDto<List<User>>> getUsuarios() {
        List<User> data = userRepo.findAll().stream()
                .map(UserMapper::toDomain).collect(Collectors.toList());
        return ResponseEntity.ok(DataResultDto.success(data));
    }

    @Operation(summary = "Listar pedidos")
    @GetMapping("/pedidos")
    public ResponseEntity<DataResultDto<List<Order>>> getPedidos() {
        List<Order> data = orderRepo.findAll().stream()
                .map(OrderMapper::toDomain).collect(Collectors.toList());
        return ResponseEntity.ok(DataResultDto.success(data));
    }

    @Operation(summary = "Listar formas de pago")
    @GetMapping("/formas-pago")
    public ResponseEntity<DataResultDto<List<FormaPago>>> getFormasPago() {
        List<FormaPago> data = formaPagoRepo.findAll().stream()
                .map(FormaPagoMapper::toDomain).collect(Collectors.toList());
        return ResponseEntity.ok(DataResultDto.success(data));
    }

    @Operation(summary = "Listar platos")
    @GetMapping("/platos")
    public ResponseEntity<DataResultDto<List<Map<String, Object>>>> getPlatos() {
        List<Map<String, Object>> data = platoRepo.findAll().stream()
                .map(e -> {
                    Map<String, Object> m = new HashMap<>();
                    m.put("plaId", e.getPlaId());
                    m.put("plaDescripcion", e.getPlaDescripcion());
                    m.put("plaPrecio", e.getPlaPrecio());
                    return m;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(DataResultDto.success(data));
    }

    @Operation(summary = "Listar recibos de caja (resumen)")
    @GetMapping("/recibos")
    public ResponseEntity<DataResultDto<List<CashReceipt>>> getRecibos() {
        List<CashReceipt> data = cashReceiptRepo.findAll().stream()
                .map(CashReceiptMapper::toDomain).collect(Collectors.toList());
        return ResponseEntity.ok(DataResultDto.success(data));
    }
}

package development.v.development.infrastruture.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.models.Order;
import development.v.development.domain.models.Branch;
import development.v.development.domain.models.User;
import development.v.development.domain.responses.DataResultDto;
import development.v.development.infrastruture.mappers.PaymentMethodMapper;
import development.v.development.infrastruture.mappers.OrderMapper;
import development.v.development.infrastruture.mappers.BranchMapper;
import development.v.development.infrastruture.mappers.UserMapper;
import development.v.development.infrastruture.repositories.CashReceipt.CashReceipJpaRepository;
import development.v.development.infrastruture.repositories.PaymentMethod.PaymentMethodJpaRepository;
import development.v.development.infrastruture.repositories.Order.OrderJpaRepository;
import development.v.development.infrastruture.repositories.Dish.DishJpaRepository;
import development.v.development.infrastruture.repositories.Branch.BranchJpaRepository;
import development.v.development.infrastruture.repositories.User.UserJpaRepository;
import development.v.development.infrastruture.mappers.CashReceiptMapper;
import development.v.development.domain.models.CashReceipt;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/lookup")
@Tag(name = "Lookup", description = "Listas auxiliares para formularios")
public class LookupController {

    private final BranchJpaRepository branchRepo;
    private final UserJpaRepository userRepo;
    private final OrderJpaRepository orderRepo;
    private final PaymentMethodJpaRepository paymentMethodRepo;
    private final DishJpaRepository dishRepo;
    private final CashReceipJpaRepository cashReceiptRepo;

    public LookupController(
            BranchJpaRepository branchRepo,
            UserJpaRepository userRepo,
            OrderJpaRepository orderRepo,
            PaymentMethodJpaRepository paymentMethodRepo,
            DishJpaRepository dishRepo,
            CashReceipJpaRepository cashReceiptRepo) {
        this.branchRepo = branchRepo;
        this.userRepo = userRepo;
        this.orderRepo = orderRepo;
        this.paymentMethodRepo = paymentMethodRepo;
        this.dishRepo = dishRepo;
        this.cashReceiptRepo = cashReceiptRepo;
    }

    @Operation(summary = "Listar sedes")
    @GetMapping("/sedes")
    public ResponseEntity<DataResultDto<List<Branch>>> getSedes() {
        List<Branch> data = branchRepo.findAll().stream()
                .map(BranchMapper::toDomain).collect(Collectors.toList());
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
    public ResponseEntity<DataResultDto<List<PaymentMethod>>> getFormasPago() {
        List<PaymentMethod> data = paymentMethodRepo.findAll().stream()
                .map(PaymentMethodMapper::toDomain).collect(Collectors.toList());
        return ResponseEntity.ok(DataResultDto.success(data));
    }

    @Operation(summary = "Listar platos")
    @GetMapping("/platos")
    public ResponseEntity<DataResultDto<List<Map<String, Object>>>> getPlatos() {
        List<Map<String, Object>> data = dishRepo.findAll().stream()
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

package development.v.development.infrastruture.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import development.v.development.application.features.Customer.CreateCustomer.CreateCustomerUseCase;
import development.v.development.application.features.Customer.CreateCustomer.Dtos.CreateCustomerRequestDto;
import development.v.development.domain.models.Customer;
import development.v.development.domain.responses.DataResultDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Customer", description = "Administra los clientes")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    
    private final CreateCustomerUseCase createUseCase;

    public CustomerController(CreateCustomerUseCase createUseCase) {
        this.createUseCase = createUseCase;
    }

    @Operation(
        summary = "Crea un nuevo cliente", 
        description = "Permite crear un nuevo cliente con los datos proporcionados")
    @PostMapping
    public ResponseEntity<DataResultDto<Customer>> create(
        @Valid 
        @RequestBody CreateCustomerRequestDto request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(createUseCase.execute(request));
    }
}

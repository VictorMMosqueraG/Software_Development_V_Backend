package development.v.development.application.features.PaymentMethod.GetAllPaymentMethod;

import java.util.List;

import org.springframework.stereotype.Service;

import development.v.development.application.features.PaymentMethod.GetAllPaymentMethod.Dtos.GetAllPaymentMethodQuery;
import development.v.development.application.features.PaymentMethod.GetAllPaymentMethod.Mappers.GetAllPaymentMethodMapper;
import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.repositories.PaymentMethodRepository;
import development.v.development.domain.responses.PaginatedResultDto;

@Service
public class GetAllPaymentMethodUseCase {

    private final PaymentMethodRepository repository;

    public GetAllPaymentMethodUseCase(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<PaymentMethod>> execute(GetAllPaymentMethodQuery query) {
        return repository.findAllPaginated(GetAllPaymentMethodMapper.toFilter(query));
    }
}

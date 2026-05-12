package development.v.development.application.features.PaymentMethod.CreatePaymentMethod;

import org.springframework.stereotype.Service;

import development.v.development.application.features.PaymentMethod.CreatePaymentMethod.Dtos.CreatePaymentMethodRequestDto;
import development.v.development.application.features.PaymentMethod.CreatePaymentMethod.Mappers.CreatePaymentMethodMapper;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.repositories.PaymentMethodRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class CreatePaymentMethodUseCase {

    private final PaymentMethodRepository repository;

    public CreatePaymentMethodUseCase(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<PaymentMethod> execute(CreatePaymentMethodRequestDto request) {
        PaymentMethod domain = CreatePaymentMethodMapper.toDomain(request);
        repository.save(domain);
        return DataResultDto.success(domain, Message.SUCCESS);
    }
}

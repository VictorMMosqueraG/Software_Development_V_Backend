package development.v.development.application.features.PaymentMethod.UpdatePaymentMethod;

import org.springframework.stereotype.Service;

import development.v.development.application.features.PaymentMethod.UpdatePaymentMethod.Dtos.UpdatePaymentMethodRequest;
import development.v.development.application.features.PaymentMethod.UpdatePaymentMethod.Mappers.UpdatePaymentMethodMapper;
import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.repositories.PaymentMethodRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class UpdatePaymentMethodUseCase {
    private final PaymentMethodRepository repository;

    public UpdatePaymentMethodUseCase(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<PaymentMethod> execute(Long id, UpdatePaymentMethodRequest request) {
        repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));

        PaymentMethod domain = UpdatePaymentMethodMapper.toDomain(id, request);
        PaymentMethod updated = repository.update(domain);
        return DataResultDto.success(updated, Message.SUCCESS);
    }
}

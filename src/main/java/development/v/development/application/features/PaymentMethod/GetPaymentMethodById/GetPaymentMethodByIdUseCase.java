package development.v.development.application.features.PaymentMethod.GetPaymentMethodById;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.repositories.PaymentMethodRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class GetPaymentMethodByIdUseCase {
    private final PaymentMethodRepository repository;

    public GetPaymentMethodByIdUseCase(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<PaymentMethod> execute(Long id) {
        PaymentMethod model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        return DataResultDto.success(model, Message.SUCCESS);
    }
}

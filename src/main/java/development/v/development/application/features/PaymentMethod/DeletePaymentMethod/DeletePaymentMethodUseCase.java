package development.v.development.application.features.PaymentMethod.DeletePaymentMethod;

import org.springframework.stereotype.Service;

import development.v.development.domain.exceptions.NotFoundException;
import development.v.development.domain.messages.Message;
import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.repositories.PaymentMethodRepository;
import development.v.development.domain.responses.DataResultDto;

@Service
public class DeletePaymentMethodUseCase {
    private final PaymentMethodRepository repository;

    public DeletePaymentMethodUseCase(PaymentMethodRepository repository) {
        this.repository = repository;
    }

    public DataResultDto<PaymentMethod> execute(Long id) {
        PaymentMethod model = repository.findById(id)
                .orElseThrow(() -> new NotFoundException(Message.NOT_FOUND));
        repository.delete(id);
        return DataResultDto.success(model, Message.SUCCESS);
    }
}

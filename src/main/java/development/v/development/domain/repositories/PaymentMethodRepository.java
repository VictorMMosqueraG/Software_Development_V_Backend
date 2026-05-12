package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.PaymentMethod;
import development.v.development.domain.responses.PaginatedResultDto;

public interface PaymentMethodRepository {
    PaymentMethod save(PaymentMethod paymentMethod);
    Optional<PaymentMethod> findById(Long fpId);
    PaginatedResultDto<List<PaymentMethod>> findAllPaginated(EntityFilter filter);
    PaymentMethod update(PaymentMethod paymentMethod);
    void delete(Long id);
}

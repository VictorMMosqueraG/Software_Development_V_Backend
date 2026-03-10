package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.responses.PaginatedResultDto;

public interface CashReceiptRepository {
    
    CashReceipt save(CashReceipt cashReceipt);
    PaginatedResultDto<List<CashReceipt>> findAllPaginated(EntityFilter filter);
    Optional<CashReceipt> findById(Integer id);
    CashReceipt update(CashReceipt cashReceipt);
}

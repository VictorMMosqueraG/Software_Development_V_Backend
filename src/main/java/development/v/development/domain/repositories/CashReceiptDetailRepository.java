package development.v.development.domain.repositories;

import java.util.List;
import java.util.Optional;

import development.v.development.domain.filters.EntityFilter;
import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.domain.responses.PaginatedResultDto;

public interface CashReceiptDetailRepository {

    CashReceiptDetail save(CashReceiptDetail detail);
    PaginatedResultDto<List<CashReceiptDetail>> findAllPaginated(EntityFilter filter);
    Optional<CashReceiptDetail> findById(Long id);
    CashReceiptDetail update(CashReceiptDetail detail);
    void delete(Long id);
}

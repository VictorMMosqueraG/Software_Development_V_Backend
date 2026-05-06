package development.v.development.application.features.CashReceiptDetail.FindAllCashReceiptDetail;

import development.v.development.application.features.CashReceiptDetail.FindAllCashReceiptDetail.Dtos.GetAllCashReceiptDetailQuery;
import development.v.development.application.features.CashReceiptDetail.FindAllCashReceiptDetail.Mappers.GetAllCashReceiptDetailMapper;
import development.v.development.domain.models.CashReceiptDetail;
import development.v.development.domain.repositories.CashReceiptDetailRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCashReceiptDetailUseCase {

    private final CashReceiptDetailRepository repository;

    public GetAllCashReceiptDetailUseCase(CashReceiptDetailRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<CashReceiptDetail>> execute(GetAllCashReceiptDetailQuery query) {
        return repository.findAllPaginated(GetAllCashReceiptDetailMapper.toFilter(query));
    }
}

package development.v.development.application.cases.CashReceipt.FindAllCashReceipt;

import development.v.development.application.cases.CashReceipt.FindAllCashReceipt.Dtos.GetAllCashReceiptQuery;
import development.v.development.application.cases.CashReceipt.FindAllCashReceipt.Mappers.GetAllCashReceiptMapper;
import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.domain.responses.PaginatedResultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCashReceiptUseCase {

    private final CashReceiptRepository repository;

    public GetAllCashReceiptUseCase(CashReceiptRepository repository) {
        this.repository = repository;
    }

    public PaginatedResultDto<List<CashReceipt>> execute(GetAllCashReceiptQuery query) {
        return repository.findAllPaginated(GetAllCashReceiptMapper.toFilter(query));
    }
}
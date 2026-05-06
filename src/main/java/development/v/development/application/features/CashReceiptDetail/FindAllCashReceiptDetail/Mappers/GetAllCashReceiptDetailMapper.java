package development.v.development.application.features.CashReceiptDetail.FindAllCashReceiptDetail.Mappers;

import development.v.development.application.features.CashReceiptDetail.FindAllCashReceiptDetail.Dtos.GetAllCashReceiptDetailQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllCashReceiptDetailMapper {

    public static EntityFilter toFilter(GetAllCashReceiptDetailQuery query) {
        return new EntityFilter(query)
                .addFilter("rcNum", query.getRcNum())
                .addFilter("plaId", query.getPlaId());
    }
}

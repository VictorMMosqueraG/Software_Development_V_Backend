package development.v.development.application.cases.CashReceipt.FindAllCashReceipt.Mappers;

import development.v.development.application.cases.CashReceipt.FindAllCashReceipt.Dtos.GetAllCashReceiptQuery;
import development.v.development.domain.filters.EntityFilter;

public class GetAllCashReceiptMapper {

    public static EntityFilter toFilter(GetAllCashReceiptQuery query) {
        return new EntityFilter(query)
                .addFilter("rcEstado", query.getRcEstado())
                .addFilter("cliId", query.getCliId())
                .addFilter("usuId", query.getUsuId());
    }
}
package development.v.development.domain.repositories;

import development.v.development.domain.models.CashReceipt;

public interface CashReceiptRepository {
    
    CashReceipt save(CashReceipt cashReceipt);
}

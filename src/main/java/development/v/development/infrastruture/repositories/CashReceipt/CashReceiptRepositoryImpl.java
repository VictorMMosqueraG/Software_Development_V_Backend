package development.v.development.infrastruture.repositories.CashReceipt;

import org.springframework.stereotype.Repository;

import development.v.development.domain.models.CashReceipt;
import development.v.development.domain.repositories.CashReceiptRepository;
import development.v.development.infrastruture.entities.CashReceiptEntity;
import development.v.development.infrastruture.mappers.CashReceiptMapper;

@Repository
public class CashReceiptRepositoryImpl implements CashReceiptRepository {

    private final CashReceipJpaRepository jpaRepository;

    public CashReceiptRepositoryImpl(CashReceipJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public CashReceipt save(CashReceipt cashReceipt) {
        CashReceiptEntity entity = CashReceiptMapper.toEntity(cashReceipt);
        return CashReceiptMapper.toDomain(jpaRepository.save(entity));
    }


}
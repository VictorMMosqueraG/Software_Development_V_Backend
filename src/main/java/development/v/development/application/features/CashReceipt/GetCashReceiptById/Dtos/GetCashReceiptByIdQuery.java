package development.v.development.application.features.CashReceipt.GetCashReceiptById.Dtos;

public class GetCashReceiptByIdQuery {
    private Integer id;

    public GetCashReceiptByIdQuery(Integer id) {
        this.id = id;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
}

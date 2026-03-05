package development.v.development.domain.responses;

public class PaginatedResultDto<T> extends DataResultDto<T> {

    private int total;
    private int page;
    private int pageSize;
    private boolean hasNext;
    private boolean hasPrev;

    public PaginatedResultDto() {
        super();
    }

    private PaginatedResultDto(int total, int page, int pageSize, T results, String message) {
        super(results);
        this.setMessage(message);
        this.total = Math.max(0, total);
        this.page = page;
        this.pageSize = pageSize;
        int totalPages = total > 0 ? (int) Math.ceil((double) total / pageSize) : 0;
        this.hasNext = page < totalPages;
        this.hasPrev = page > 1;
    }

    public static <T> PaginatedResultDto<T> success(int total, int page, int pageSize, T results, String message) {
        return new PaginatedResultDto<>(total, page, pageSize, results, message);
    }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getPageSize() { return pageSize; }
    public void setPageSize(int pageSize) { this.pageSize = pageSize; }

    public boolean isHasNext() { return hasNext; }
    public void setHasNext(boolean hasNext) { this.hasNext = hasNext; }

    public boolean isHasPrev() { return hasPrev; }
    public void setHasPrev(boolean hasPrev) { this.hasPrev = hasPrev; }
}
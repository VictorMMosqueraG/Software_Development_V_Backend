package development.v.development.domain.responses;

public class DataResultDto<T> extends ResultDto<T> {

    private T results;

    public DataResultDto() {
        super();
    }

    protected DataResultDto(T results) {
        super("");
        this.results = results;
    }

    public static <T> DataResultDto<T> success(T result) {
        return new DataResultDto<>(result);
    }

    public static <T> DataResultDto<T> success(T result, String message) {
        DataResultDto<T> response = new DataResultDto<>(result);
        response.setMessage(message);
        return response;
    }

    public T getResults() { return results; }
    public void setResults(T results) { this.results = results; }
}
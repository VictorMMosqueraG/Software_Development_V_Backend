package development.v.development.domain.responses;

public class ResultDto<T> {
    private String message;

    public ResultDto() {
    }

    protected ResultDto(String message) {
        this.message = message;
    }

    public static <T> ResultDto<T> success(String message) {
        return new ResultDto<>(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
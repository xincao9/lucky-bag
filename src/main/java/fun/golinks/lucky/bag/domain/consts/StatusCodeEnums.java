package fun.golinks.lucky.bag.domain.consts;

public enum StatusCodeEnums {

    SUCCESS(0, "Success"),
    BAD_REQUEST(1, "Bad request"),
    RATE_LIMIT_EXCEEDED(2, "Rate limit exceeded"),
    INTERNAL_SERVER_ERROR(3, "Internal server error");

    private final Integer code;
    private final String message;

    StatusCodeEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

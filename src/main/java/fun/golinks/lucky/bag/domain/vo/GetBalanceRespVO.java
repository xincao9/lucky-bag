package fun.golinks.lucky.bag.domain.vo;

import lombok.Data;

@Data
public class GetBalanceRespVO {

    private String jsonrpc;
    private Result result;
    private Integer id;

    @Data
    public static class Result {
        private Context context;
        private Long value;
    }

    @Data
    public static class Context {
        private Long slot;
    }
}

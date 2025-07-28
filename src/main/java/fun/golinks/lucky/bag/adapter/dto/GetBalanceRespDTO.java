package fun.golinks.lucky.bag.adapter.dto;

import lombok.Data;

@Data
public class GetBalanceRespDTO {
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
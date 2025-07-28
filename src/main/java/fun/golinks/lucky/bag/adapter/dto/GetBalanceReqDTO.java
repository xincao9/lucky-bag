package fun.golinks.lucky.bag.adapter.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetBalanceReqDTO {
    private String jsonrpc = "2.0";
    private Integer id = 0;
    private String method;
    private List<Object> params;
}

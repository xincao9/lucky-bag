package fun.golinks.lucky.bag.adapter.client;

import fun.golinks.lucky.bag.adapter.dto.GetBalanceReqDTO;
import fun.golinks.lucky.bag.adapter.dto.GetBalanceRespDTO;
import fun.golinks.lucky.bag.adapter.properties.SolanaProperties;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class GetBalanceClient {

    @Resource
    private SolanaProperties solanaProperties;
    @Resource
    private RestTemplate restTemplate;

    public GetBalanceRespDTO execute(String address) {
        GetBalanceReqDTO reqDTO = new GetBalanceReqDTO();
        List<Object> params = new ArrayList<>(2);
        params.add(address);
        params.add(Collections.singletonMap("commitment", "finalized"));
        reqDTO.setJsonrpc("2.0");
        reqDTO.setId(0);
        reqDTO.setMethod("getBalance");
        reqDTO.setParams(params);
        HttpEntity<GetBalanceReqDTO> request = new HttpEntity<>(reqDTO);
        ResponseEntity<GetBalanceRespDTO> response = null;
        try {
            response = restTemplate.exchange(new URI(solanaProperties.getEndpoint()), HttpMethod.POST, request, GetBalanceRespDTO.class);
            return response.getBody();
        } catch (Throwable e) {
            log.error("GetBalanceClient.execute error: {}", e.getMessage(), e);
        }
        return null;
    }

    public Long getBalance(String address) {
        GetBalanceRespDTO getBalanceRespDTO = execute(address);
        if (getBalanceRespDTO == null) {
            return -1L;
        }
        GetBalanceRespDTO.Result result = getBalanceRespDTO.getResult();
        if (result == null) {
            return -1L;
        }
        return result.getValue();
    }
}

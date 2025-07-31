package fun.golinks.lucky.bag.core.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONWriter;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class WalletServiceTests {

    @Resource
    private WalletService walletService;

    @Test
    public void testCreateNewAccount() {
        List<String> addresses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String address = walletService.createNewAccount();
            if (StringUtils.isNotBlank(address)) {
                addresses.add(address);
            }
        }
        System.out.println(JSON.toJSONString(addresses, JSONWriter.Feature.PrettyFormat));
    }
}

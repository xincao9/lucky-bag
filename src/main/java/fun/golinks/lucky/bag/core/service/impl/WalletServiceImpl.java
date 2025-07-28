package fun.golinks.lucky.bag.core.service.impl;

import fun.golinks.lucky.bag.adapter.client.GetBalanceClient;
import fun.golinks.lucky.bag.core.service.WalletService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Resource
    private GetBalanceClient getBalanceClient;

    @Override
    public Long getBalance(String address) {
        return getBalanceClient.getBalance(address);
    }
}

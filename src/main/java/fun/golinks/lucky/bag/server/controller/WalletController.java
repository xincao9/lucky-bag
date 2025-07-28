package fun.golinks.lucky.bag.server.controller;

import fun.golinks.lucky.bag.core.service.WalletService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("wallet")
@RestController
public class WalletController {

    @Resource
    private WalletService walletService;

    @GetMapping("getBalance")
    public Long getBalance(@RequestParam("address") String address) {
        return walletService.getBalance(address);
    }
}

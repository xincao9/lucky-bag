package fun.golinks.lucky.bag.server.controller;

import fun.golinks.lucky.bag.core.service.WalletService;
import fun.golinks.lucky.bag.domain.vo.RespVO;
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
    public RespVO<Long> getBalance(@RequestParam("address") String address) {
        return RespVO.ok(walletService.getBalance(address));
    }

    @GetMapping("createNewAccount")
    public RespVO<String> createNewAccount() {
        return RespVO.ok(walletService.createNewAccount());
    }
}

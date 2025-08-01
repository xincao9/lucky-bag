package fun.golinks.lucky.bag.core.service.impl;

import fun.golinks.lucky.bag.core.service.WalletService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import software.sava.core.accounts.PublicKey;
import software.sava.core.accounts.Signer;
import software.sava.rpc.json.http.client.SolanaRpcClient;
import software.sava.rpc.json.http.response.Lamports;

import java.util.Base64;
import java.util.concurrent.CompletableFuture;

@Service
public class WalletServiceImpl implements WalletService {

    private final Logger log = LoggerFactory.getLogger(WalletServiceImpl.class);

    @Resource
    private SolanaRpcClient solanaRpcClient;

    @Override
    public Long getBalance(String address) {
        CompletableFuture<Lamports> balance = solanaRpcClient.getBalance(PublicKey.fromBase58Encoded(address));
        try {
            Lamports lamports = balance.get();
            return lamports.asLong();
        } catch (Throwable e) {
            log.error("getBalance error", e);
        }
        return -1L;
    }

    @Override
    public String createNewAccount() {
        byte[] privateKeyPairBytes = Signer.generatePrivateKeyBytes();
        Signer signer = Signer.createFromPrivateKey(privateKeyPairBytes);
        log.info("privateKey: {}", Base64.getEncoder().encodeToString(privateKeyPairBytes));
        PublicKey publicKey = signer.publicKey();
        return publicKey.toBase58();
    }
}

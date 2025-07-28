package fun.golinks.lucky.bag.core.service;

public interface WalletService {

    Long getBalance(String address);

    String createNewAccount();
}

package fun.golinks.lucky.bag.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.sava.rpc.json.http.SolanaNetwork;
import software.sava.rpc.json.http.client.SolanaRpcClient;

import java.net.http.HttpClient;

@Configuration
public class SolanaConfig {

    @Bean
    public SolanaRpcClient solanaRpcClient() {
        HttpClient httpClient = HttpClient.newHttpClient();
        return SolanaRpcClient.createClient(
                SolanaNetwork.MAIN_NET.getEndpoint(),
                httpClient
        );
    }
}

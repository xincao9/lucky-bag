package fun.golinks.lucky.bag.adapter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "solana")
@Component
public class SolanaProperties {

    private String endpoint = "";
}

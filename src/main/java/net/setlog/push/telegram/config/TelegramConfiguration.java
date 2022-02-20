package net.setlog.push.telegram.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix="telegram.api")
public class TelegramConfiguration {

    private String botToken;
    private String chatId;
    private String username;
    private boolean enabled;

}

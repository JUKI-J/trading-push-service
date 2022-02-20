package net.setlog.push.telegram.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.setlog.push.telegram.config.TelegramConfiguration;
import net.setlog.push.telegram.service.TelegramService;
import net.setlog.push.telegram.vo.TelegramPushVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;


@Service
@AllArgsConstructor
@Slf4j
public class TelegramServiceImpl implements TelegramService {

    private final TelegramConfiguration telegramConfiguration;
    private final RestTemplate restTemplate;

    @Override
    public void send(TelegramPushVO telegramPushVO) throws Exception {

        if (telegramConfiguration.isEnabled()) {
            String url = "https://api.telegram.org/" + telegramConfiguration.getBotToken() + "/sendMessage";
            try {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));    //Response Header to UTF-8

                UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                        .queryParam("chat_id", telegramConfiguration.getChatId())
                        .queryParam("text", telegramPushVO.getMessage())
                        .build(true);

                log.info("builder : {}", builder);

                Object response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);
                log.debug("-----telegram response : {}", response);
            } catch (Exception e) {
                log.error("Unhandled exception occurred while send Telegram.", e);
            }
        }


    }
}

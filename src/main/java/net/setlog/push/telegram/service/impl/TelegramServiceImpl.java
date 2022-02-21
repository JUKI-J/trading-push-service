package net.setlog.push.telegram.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.setlog.push.telegram.config.TelegramConfiguration;
import net.setlog.push.telegram.service.TelegramService;
import net.setlog.push.telegram.vo.TelegramPushVO;
import net.setlog.push.telegram.vo.api.TelegramResultVO;
import org.springframework.http.*;
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
    public TelegramResultVO send(TelegramPushVO telegramPushVO) throws Exception {
        TelegramResultVO telegramResultVO = new TelegramResultVO();
        if (telegramConfiguration.isEnabled()) {
            String url = String.format("https://api.telegram.org/bot%s/sendmessage", telegramConfiguration.getBotToken());
            try {
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
                UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                        .queryParam("chat_id", telegramConfiguration.getChatId())
                        .queryParam("text", telegramPushVO.getMessage())
                        .build()
                ;
                log.debug("-----UriComponents : {}", uriComponents.toUriString());
                telegramResultVO = restTemplate.getForObject(uriComponents.toUriString(), TelegramResultVO.class);
            } catch (Exception e) {
                log.error("Unhandled exception occurred while send Telegram.", e);
            }
        }else{
            log.error("Exception occurred before send Telegram. [ telegramConfiguration.isEnabled() : {} ]", telegramConfiguration.isEnabled());
        }
        log.info("-----telegramResultVO : {}", telegramResultVO);
        return telegramResultVO;
    }
}

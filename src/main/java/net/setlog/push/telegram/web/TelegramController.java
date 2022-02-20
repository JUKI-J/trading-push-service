package net.setlog.push.telegram.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.setlog.push.telegram.service.TelegramService;
import net.setlog.push.telegram.vo.TelegramPushVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/telegram")
@AllArgsConstructor
@Slf4j
public class TelegramController {

    private final TelegramService telegramService;

    //search/list
    //search/detail
    //send

    @GetMapping("/")
    public Map<String, Object> greeting() {
        return Collections.singletonMap("message", "Hello, World");
    }

    @GetMapping("/send")
    public Map<String, Object> send(TelegramPushVO telegramPushVO) throws Exception {

        telegramService.send(telegramPushVO);

        return Collections.singletonMap("message", "Hello, World");
    }


}

package net.setlog.push.telegram.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.setlog.push.telegram.service.TelegramService;
import net.setlog.push.telegram.vo.TelegramPushSearchVO;
import net.setlog.push.telegram.vo.TelegramPushVO;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/telegram")
@AllArgsConstructor
@Slf4j
public class TelegramController {

    private final TelegramService telegramService;

    //get
    //search/list

    //get
    //search/detail

    //post
    //send

    @GetMapping("/search/list")
    public Map<String, Object> searchSendList(TelegramPushSearchVO telegramPushSearchVO) throws Exception {


        return Collections.singletonMap("message", "Hello, World");
    }

    @GetMapping("/search/detail")
    public Map<String, Object> searchSendDetail(TelegramPushSearchVO telegramPushSearchVO) throws Exception {


        return Collections.singletonMap("message", "Hello, World");
    }

    @PostMapping("/send")
    public Map<String, Object> send(TelegramPushVO telegramPushVO) throws Exception {

        telegramService.send(telegramPushVO);

        return Collections.singletonMap("message", "Hello, World");
    }

    @PostMapping("/sendList")
    public Map<String, Object> send(List<TelegramPushVO> telegramPushVO) throws Exception {
        return Collections.singletonMap("message", "Hello, World");
    }

}

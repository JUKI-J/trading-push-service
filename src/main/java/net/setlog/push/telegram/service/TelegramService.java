package net.setlog.push.telegram.service;

import net.setlog.push.telegram.vo.TelegramPushVO;
import net.setlog.push.telegram.vo.api.TelegramResultVO;

public interface TelegramService {

    TelegramResultVO send(TelegramPushVO telegramPushVO) throws Exception;

}

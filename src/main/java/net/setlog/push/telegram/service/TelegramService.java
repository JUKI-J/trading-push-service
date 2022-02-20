package net.setlog.push.telegram.service;

import net.setlog.push.telegram.vo.TelegramPushVO;

public interface TelegramService {

    void send(TelegramPushVO telegramPushVO) throws Exception;

}

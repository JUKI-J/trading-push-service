package net.setlog.push.telegram.vo.api;

import lombok.Data;

@Data
public class TelegramResponseVO {

    private long message_id;
    private TelegramFromVO from;
    private TelegramChatVO chat;
    private long date;
    private String text;

}

package net.setlog.push.telegram.vo.api;

import lombok.Data;

@Data
public class TelegramChatVO {

    private long id;
    private String first_name;
    private String last_name;
    private String type;

}

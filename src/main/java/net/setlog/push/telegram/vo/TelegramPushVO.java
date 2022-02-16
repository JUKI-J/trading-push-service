package net.setlog.push.telegram.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelegramPushVO {

    private Long pushId;
    private String message;
    private String chatId;

}

package net.setlog.push.telegram.vo.api;

import lombok.Data;

@Data
public class TelegramFromVO {

    private long id;
    private String is_bot;              //boolean, remove prefix "is"
    private String first_name;
    private String username;

}

package net.setlog.push.telegram.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.setlog.push.common.pagination.PaginationInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelegramPushSearchVO extends PaginationInfo {

    private Long pushId;
    private String message;
    private String chatId;

}

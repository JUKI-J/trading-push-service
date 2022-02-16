package net.setlog.push.common.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInfo {

    private int currentPageNo;
    private int recordCountPerPage;
    private int pageSize;
    private int totalRecordCount;

}

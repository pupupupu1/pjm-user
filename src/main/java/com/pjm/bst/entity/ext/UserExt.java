package com.pjm.bst.entity.ext;

import com.pjm.bst.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserExt extends User {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private List<String> ids;
}

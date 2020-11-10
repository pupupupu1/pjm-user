package com.pjm.bst.controller;


import com.pjm.bst.common.bean.PageVo;
import com.pjm.bst.common.bean.ResponseEntity;
import com.pjm.bst.entity.User;
import com.pjm.bst.entity.ext.UserExt;
import com.pjm.bst.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pjm
 * @since 2020-11-10
 */
@Api(tags = {"用户表"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/insert")
    public ResponseEntity<String> insert(@RequestBody User user) throws Exception {
        return userService.insertUser(user);
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestBody UserExt userExt) {
        return userService.delete(userExt);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/list")
    public ResponseEntity<PageVo<List<User>>> list(@RequestBody UserExt userExt) {
        return userService.getList(userExt, userExt.getPageNum(), userExt.getPageSize());
    }
}


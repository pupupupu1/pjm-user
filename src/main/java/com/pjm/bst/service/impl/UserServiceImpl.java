package com.pjm.bst.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.pjm.bst.common.bean.PageVo;
import com.pjm.bst.common.bean.ResponseEntity;
import com.pjm.bst.entity.User;
import com.pjm.bst.entity.ext.UserExt;
import com.pjm.bst.mapper.UserMapper;
import com.pjm.bst.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pjm.bst.util.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author pjm
 * @since 2020-11-10
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public ResponseEntity<String> insertUser(User user) throws Exception {
        //校验user
        String password = user.getPassword();
        user.setPassword(MD5Utils.md5(password, String.valueOf(user.getId())));
        user.setCreateTime(new Date());
        user.setState("1");
        insert(user);
        return ResponseEntity.success("success");
    }

    @Override
    public ResponseEntity<String> delete(UserExt userExt) {
        userExt.getIds().add("00000");
        Wrapper<User> wrapper = new EntityWrapper<>(new User());
        wrapper.in("id", userExt.getIds()).eq("state", "1");
        update(new User().setState("1"), wrapper);
        return ResponseEntity.success("success");
    }

    @Override
    public ResponseEntity<String> update(User user) {
        Wrapper<User> wrapper = new EntityWrapper<>(new User());
        wrapper.eq("state", "1");
        update(user, wrapper);
        return ResponseEntity.success("success");
    }

    @Override
    public ResponseEntity<PageVo<List<User>>> getList(UserExt userExt, Integer pageNum, Integer pageSize) {
        if (pageNum > 0 && pageSize > 0) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Wrapper<User> wrapper = new EntityWrapper<>(new User());
        if (StringUtils.isEmpty(userExt.getMobile())) {
            wrapper.like("mobile", userExt.getMobile());
        }
        wrapper.eq("state", "1");
        List<User> users = selectList(wrapper);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return ResponseEntity.success(new PageVo<>(pageNum, pageSize, pageInfo.getTotal(), pageInfo.getList()));
    }
}

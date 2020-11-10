package com.pjm.bst.service;

import com.pjm.bst.common.bean.PageVo;
import com.pjm.bst.common.bean.ResponseEntity;
import com.pjm.bst.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.pjm.bst.entity.ext.UserExt;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author pjm
 * @since 2020-11-10
 */
public interface IUserService extends IService<User> {
   ResponseEntity<String> insertUser(User user) throws Exception;
   ResponseEntity<String> delete(UserExt userExt);
   ResponseEntity<String> update(User user);
   ResponseEntity<PageVo<List<User>>> getList(UserExt userExt,Integer pageNum,Integer PageSize);
}

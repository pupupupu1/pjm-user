package com.pjm.bst.mapper;

import com.pjm.bst.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author pjm
 * @since 2020-11-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

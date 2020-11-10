package com.pjm.bst.entity;

import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author pjm
 * @since 2020-11-10
 */
@ApiModel(value = "用户表")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "登录名，使用电话号码作为登录名")
    private String mobile;
    @ApiModelProperty(value = "登录密码")
    private String password;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "出生日期")
    private Date birthdate;
    @ApiModelProperty(value = "详细地址")
    private String address;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "-1:表示删除 ，1：正常状态")
    private String state;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
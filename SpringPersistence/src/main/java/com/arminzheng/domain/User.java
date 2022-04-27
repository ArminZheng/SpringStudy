package com.arminzheng.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * User
 *
 * @author zy
 * @version 2022/4/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 主键，用户ID,序列BASE_USER_SEQ */
    private String userId;
    /** 部门ID */
    private String depId;
    /** 用户名 */
    private String userName;
    /** 登陆ID */
    private String loginId;
    /** 密码 */
    private String passwd;
    /** 手机号码 */
    private String mobileNo;
    /** 联系电话 */
    private String phoneNo;
    /** 地址 */
    private String address;
    /** 邮编 */
    private String postCode;
    /** 邮件 */
    private String email;
    /** 状态：0停用1正常(2-锁定,3-休假，乐山)2待审核3注销4未登陆过(新用户)5锁定P:待审核 */
    private String userState;
    /** 备注 */
    private String remark;
    /** 创建人 */
    private String creator;
    /** 创建时间 */
    private Date gmtCreate;
    /** 最近修改人 */
    private String modifier;
    /** 最近修改时间 */
    private Date gmtModified;
    /** 传真 */
    private String faxNo;
    /** 报文接收，0-不接收,1-接收 */
    private String receiveMessage;
    /** 邮件接收，0-不接收,1-接收 */
    private String receiveEmail;
    /** 字符类扩展字段1 */
    private String ext01;
    /** 字符类扩展字段2 */
    private String ext02;
    /** 字符类扩展字段3 */
    private String ext03;
    /** 字符类扩展字段4：是否可以仅密码登录 */
    private String ext04;
    /** 整型类扩展字段5：user_type人员类型 */
    private Integer ext05;
    /** 日期类扩展字段6 */
    private Date ext06;
    /** 日期类扩展字段7 */
    private Date ext07;
    /** 金额类扩展字段8 */
    private Long ext08;
    /** 金额类扩展字段9 */
    private Long ext09;
    /** 外键，机构ID */
    private String orgId;
    /** 用户来源 */
    private String source;
    /** 机构编码 */
    private String orgCode;
    /** 角色编码 */
    private String roleCode;
    /** 用户连续登陆错误次数 */
    private Long loginErrorTimes;
    /** 用户最后一次登陆的日期 */
    private Date lastLoginDatetime;
    /** 微信号 */
    private String weixinId;
    /** */
    private Date lastLoginDate;
    /** 柜员类型 */
    private String tellerType;

    public User(
            String userId,
            String userName,
            String loginId,
            String userState,
            String creator,
            Date gmtCreate,
            String modifier,
            Date gmtModified) {
        this.userId = userId;
        this.userName = userName;
        this.loginId = loginId;
        this.userState = userState;
        this.creator = creator;
        this.gmtCreate = gmtCreate;
        this.modifier = modifier;
        this.gmtModified = gmtModified;
    }

    public static User getInstance() {
        return new User(
                UUID.randomUUID().toString().replaceAll("-", ""),
                "zhangshan",
                "zhangshan",
                "0",
                "1",
                new Date(),
                "1",
                new Date());
    }
}

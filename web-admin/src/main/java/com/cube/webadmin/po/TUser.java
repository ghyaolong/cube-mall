package com.cube.webadmin.po;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_user")
@Data
public class TUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_by")
    private String updateBy;

    @Column(name = "update_time")
    private Date updateTime;

    private String address;

    private String avatar;

    private String description;

    private String email;

    private String mobile;

    @Column(name = "nick_name")
    private String nickName;

    private String password;

    private String sex;

    private Integer status;

    private Integer type;

    private String username;

    @Column(name = "del_flag")
    private Integer delFlag;

    @Column(name = "department_id")
    private String departmentId;

    private String street;

    @Column(name = "pass_strength")
    private String passStrength;

    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }



}
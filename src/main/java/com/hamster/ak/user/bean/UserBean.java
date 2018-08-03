package com.hamster.ak.user.bean;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserBean {
    private Integer id;
    private String loginName;
    private String name;
    private String password;
    private Date created;
    private Date modified;
    private String creator;
    private String modifier;
}

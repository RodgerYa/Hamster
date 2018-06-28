package com.hamster.ak.user.api;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author yanwenbo
 */
@Data
@Accessors(chain = true)
public class Token {
    private String userId;
    private String userName;
    private Date expiration;

}

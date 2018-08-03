package com.hamster.ak.user.api;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author yanwenbo
 */
@Data
@Builder
@Accessors(chain = true)
public class Token {
    private Integer userId;

    private String userName;

    private Date expiration;

}

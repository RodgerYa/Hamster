package com.hamster.ak.user.api;

import lombok.Data;

import java.util.Optional;

/**
 * @author yanwenbo
 */
@Data
public class UserFilter {
    private Optional<String> userName;
    private Optional<String> loginName;
}

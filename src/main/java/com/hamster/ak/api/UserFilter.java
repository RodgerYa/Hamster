package com.hamster.ak.api;

import lombok.Builder;
import lombok.Data;

import java.util.Optional;

/**
 * @author yanwenbo
 */
@Data
@Builder
public class UserFilter {
    private Optional<String> nameLike;
    private Optional<String> loginNameLike;
}

package com.hamster.ak.common.bean;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author yanwenbo
 */
@Data
@Builder
public class Page<T> {

    @Builder.Default
    private Integer size = 20;

    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    private Integer total = 0;

    private List<T> data = Lists.newArrayList();
}

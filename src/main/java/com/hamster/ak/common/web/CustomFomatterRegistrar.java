package com.hamster.ak.common.web;

import com.yan.jackson.EnumConverterFactory;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.Jsr310DateTimeFormatAnnotationFormatterFactory;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;

public class CustomFomatterRegistrar implements FormatterRegistrar{
    private String enumProp;

    /**
     * @param enumProp 枚举属性名
     */
    public CustomFomatterRegistrar(@NotNull String enumProp) {
        Assert.hasText(enumProp, "enum property must not be empty!");

        this.enumProp = enumProp;
    }

    @Override
    public void registerFormatters(FormatterRegistry registry) {
        addConverters(registry);
        addFormattersForFieldAnnotation(registry);
    }

    private void addConverters(FormatterRegistry registry) {
        registry.addConverterFactory(new EnumConverterFactory(enumProp));
    }

    private void addFormattersForFieldAnnotation(FormatterRegistry registry) {
        registry.addFormatterForFieldAnnotation(new Jsr310DateTimeFormatAnnotationFormatterFactory());
    }
}

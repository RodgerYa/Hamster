package com.hamster.ak.common.config;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Transactional(value = "hamsterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public @interface hamsterTx {

}
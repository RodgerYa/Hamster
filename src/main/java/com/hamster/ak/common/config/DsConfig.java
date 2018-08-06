package com.hamster.ak.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.hamster.ak.HmApplication;
import com.hamster.ak.mapper.HmMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author yanwenbo
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel"})
@Configurable
@MapperScan(basePackageClasses = HmMapper.class, sqlSessionTemplateRef = "hmSqlSessionTemplate")
public class DsConfig {

    @Primary
    @Bean(name = "hmDataSource")
    @ConfigurationProperties(prefix = "spring.dataSource")
    public DataSource hmDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "hmSqlSessionFactory")
    public SqlSessionFactory hamsterSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/*.xml"));
        return bean.getObject();
    }

    @Primary
    @Bean(name = "hmSqlSessionTemplate")
    public SqlSessionTemplate hamsterSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(hamsterSqlSessionFactory());
    }

    @Primary
    @Bean(name = "hmTransactionManager")
    public DataSourceTransactionManager hamsterTransactionManager() {
        return new DataSourceTransactionManager(hmDataSource());
    }
}

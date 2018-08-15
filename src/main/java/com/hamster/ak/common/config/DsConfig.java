package com.hamster.ak.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.hamster.ak.mapper.HmMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author yanwenbo
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel"})
@Configuration
@MapperScan(basePackageClasses = HmMapper.class, sqlSessionTemplateRef = "hamsterSqlSessionTemplate")
public class DsConfig {

    @Primary
    @Bean(name = "hmDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hm")
    public DataSource hmDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "hamsterSqlSessionFactory")
    public SqlSessionFactory hamsterSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(hmDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/*.xml"));
        bean.setTypeHandlersPackage("com.hamster.ak.common.handler");
        return bean.getObject();
    }

    @Primary
    @Bean(name = "hamsterSqlSessionTemplate")
    public SqlSessionTemplate hamsterSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(hamsterSqlSessionFactory());
    }

    @Primary
    @Bean(name = "hamsterTransactionManager")
    public DataSourceTransactionManager hamsterTransactionManager() {
        return new DataSourceTransactionManager(hmDataSource());
    }
}

package com.hamster.ak.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.hamster.ak.HmApplication;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author yanwenbo
 */
@SuppressWarnings({"AlibabaClassNamingShouldBeCamel"})
@Configurable
@MapperScan(basePackageClasses = HmApplication.class, sqlSessionTemplateRef = "hmSqlSessionTemplate")
public class DSConfig {

    @Bean(name = "hmDataSource")
    @ConfigurationProperties(prefix = "spring.dataSource")
    public DataSource hmDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "hmSqlSessionFactory")
    public SqlSessionFactory hamsterSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(hmDataSource());
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "hmSqlSessionTemplate")
    public SqlSessionTemplate hamsterSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(hamsterSqlSessionFactory());
    }

    @Bean(name = "hmTransactionManager")
    public DataSourceTransactionManager hamsterTransactionManager() {
        return new DataSourceTransactionManager(hmDataSource());
    }
}

package com.tyy.stu.jdbc;

import com.tyy.stu.adapter.entity.Person;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class DataSourceConfiguration {


    @Bean
    public LocalSessionFactoryBean entityManagerFactory(@Qualifier("studyDataBase") HikariDataSource dataSource) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setAnnotatedClasses(Person.class);
        return localSessionFactoryBean;
    }

    @Bean
    @ConfigurationProperties(prefix = "tyy.datasource.study")
    public HikariDataSource studyDataBase() {
        return new HikariDataSource();
    }

    @Bean("db_study")
    public NamedParameterJdbcTemplate studyJdbcTemplate(@Qualifier("studyDataBase") HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


    @Bean
    @ConfigurationProperties(prefix = "tyy.datasource.jaa")
    public HikariDataSource jaaDataBase() {
        return new HikariDataSource();
    }

    @Bean("db_jaa")
    public NamedParameterJdbcTemplate jaaJdbcTemplate(@Qualifier("jaaDataBase") HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


    @Bean
    @ConfigurationProperties(prefix = "tyy.datasource.bar")
    public HikariDataSource newBarDataBase() {
        return new HikariDataSource();
    }

    @Bean("db_new_bar")
    public NamedParameterJdbcTemplate newBarJdbcTemplate(@Qualifier("newBarDataBase") HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


}

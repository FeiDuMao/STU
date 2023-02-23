package com.tyy.stu.jdbc;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DataSourceConfiguration {


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


}

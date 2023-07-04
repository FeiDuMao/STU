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

    @Bean("study01")
    @ConfigurationProperties(prefix = "tyy.datasource.study01")
    public HikariDataSource study01DataBase() {
        return new HikariDataSource();
    }

    @Bean
    public LocalSessionFactoryBean entityManagerFactory(@Qualifier("study01") HikariDataSource dataSource) {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setAnnotatedClasses(Person.class);
        return localSessionFactoryBean;
    }

    @Bean("jdbc_study01")
    public NamedParameterJdbcTemplate studyJdbcTemplate(@Qualifier("study01") HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }




    @Bean("study02")
    @ConfigurationProperties(prefix = "tyy.datasource.study02")
    public HikariDataSource study02DataBase() {
        return new HikariDataSource();
    }

    @Bean("jdbc_study02")
    public NamedParameterJdbcTemplate jaaJdbcTemplate(@Qualifier("study02") HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }





    @Bean("study03")
    @ConfigurationProperties(prefix = "tyy.datasource.study03")
    public HikariDataSource study03DataBase() {
        return new HikariDataSource();
    }

    @Bean("jdbc_study03")
    public NamedParameterJdbcTemplate newBarJdbcTemplate(@Qualifier("study03") HikariDataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


}

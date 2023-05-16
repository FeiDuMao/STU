package com.tyy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
//@ConfigurationPropertiesScan("com.tyy")
//@EnableAutoConfiguration(exclude = {
//        JndiConnectionFactoryAutoConfiguration.class,
//        DataSourceAutoConfiguration.class,
//        HibernateJpaAutoConfiguration.class,
//        JpaRepositoriesAutoConfiguration.class,
//        DataSourceTransactionManagerAutoConfiguration.class
//})
@EntityScan(basePackages = "com.tyy.stu.adapter.entity")
public class TApplication {
    public static void main(String[] args) {
        SpringApplication.run(TApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        log.info("TApplication is ready !!");
    }
}

package com.tyy.configuration;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "property-test")
public class PropertiesFromYml {


    /**
     *  将配置文件中的信息保存成map
     */
    private Map<String, Object> userInfo;


}

package com.tyy.stu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import com.fasterxml.jackson.module.kotlin.KotlinModule;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class JsonUtil {

    private JsonUtil() {
    }

    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        addModule();
        addConfig();
    }

    private static void addConfig() {
        mapper.setConfig(mapper.getDeserializationConfig().with(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS));
        mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private static void addModule() {
        JavaTimeModule javaTimeModule = new JavaTimeModule();

        LocalTimeSerializer localTimeSerializer = new LocalTimeSerializer(DateTimeFormatter.ISO_LOCAL_TIME);
        LocalTimeDeserializer localTimeDeserializer = new LocalTimeDeserializer(DateTimeFormatter.ISO_LOCAL_TIME);

        LocalDateSerializer localDateSerializer = new LocalDateSerializer(DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDateDeserializer localDateDeserializer = new LocalDateDeserializer(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        javaTimeModule.addDeserializer(LocalDate.class, localDateDeserializer);
        javaTimeModule.addDeserializer(LocalTime.class, localTimeDeserializer);
        javaTimeModule.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);

        javaTimeModule.addSerializer(LocalDate.class, localDateSerializer);
        javaTimeModule.addSerializer(LocalTime.class, localTimeSerializer);
        javaTimeModule.addSerializer(LocalDateTime.class, localDateTimeSerializer);

        mapper.registerModule(javaTimeModule);
        mapper.registerModule(new KotlinModule.Builder().build());
        mapper.registerModule(new SimpleModule());

    }


    public static <T> T reade(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            log.warn("json deserialize {}.class error, json = {} ", clazz, json);
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.warn("json serialize error, obj = {}", obj);
            e.printStackTrace();
        }
        return null;
    }


}

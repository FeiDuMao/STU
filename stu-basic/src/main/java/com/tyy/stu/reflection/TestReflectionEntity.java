package com.tyy.stu.reflection;

import java.time.LocalDate;

public class TestReflectionEntity {

    public String address;
    public static final LocalDate birth = LocalDate.of(2023, 1, 1);

    private String name;
    private final String id;
    private static final Integer age = (int) (LocalDate.now().toEpochDay() - birth.toEpochDay()) / 365;


    private String getFullStr() {
        return this.id + name + address;
    }

    public String getAll() {
        return getFullStr() + age;
    }

    public TestReflectionEntity(String address, String id, String name) {
        this.address = address;
        this.id = id;
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}

package com.tyy.controller;


import com.tyy.stu.adapter.entity.Person;
import com.tyy.stu.adapter.jpa.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class TestService {


    private final PersonRepository personRepository;





    public String handle(String name, String addr) {


        Person person = Person.builder()
                .name(name)
                .address(addr)
                .build();

        personRepository.save(person);

        return "";
    }
}

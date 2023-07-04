package com.tyy.controller;


import com.tyy.stu.adapter.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {


    private final TestService service;


    @GetMapping("/test1/{name}")
    public String test1(@PathVariable String name, @RequestParam String addr) {

        service.handle(name,addr);


        
        return "test1";
    }




//
//    @PostMapping("/test1")
//    @PutMapping
//    @DeleteMapping
//





}

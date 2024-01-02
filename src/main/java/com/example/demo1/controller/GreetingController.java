package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    /*IDE는 @Value 속성을 애플리케이션이 사용한다고 인식하지 못하는 단점 존재*/
    @Value("${greeting-name: Mirage}")  // 콜론 뒤에 기본 값
    private String name;

    @Value("${greeting-coffee: ${greeting-name}} is drinking cafe gandor")
    private String coffee;

    @GetMapping
    String getGreeting() {
        return name;
    }

    @GetMapping("/coffee")
    String getNameAndCoffee() {
        return coffee;
    }
}

package com.scaler.productservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/")
    public String sample() {
        return "Hello World";
    }
    @GetMapping("/{name}")
    public String sample2(@PathVariable String name) {
        return "Welcome! " + name;
    }
}

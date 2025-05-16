package dev.vikas.productservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/1")

    public String sample() {
        return "hello worl !";
    }
    @GetMapping("/2")
    public String sample2() {
        return "hello world 2 !";
    }
}

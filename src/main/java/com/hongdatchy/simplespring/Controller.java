package com.hongdatchy.simplespring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello 12345678910";
    }
}

package com.neodinary7.hackathon.Concert;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String testController()  {
        return "success";
    }
}

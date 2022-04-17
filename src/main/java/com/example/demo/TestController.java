package com.example.demo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@AllArgsConstructor

public class TestController {

    @GetMapping(value = "/get1")
    public String get1() throws Exception {
        return "1";
    }

}

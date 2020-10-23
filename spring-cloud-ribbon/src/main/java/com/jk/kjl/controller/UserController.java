package com.jk.kjl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

@RequestMapping("/hello")
    public String hello(){

  String result=restTemplate.getForObject("http://provider/hello",String.class);
    return result;
}


}

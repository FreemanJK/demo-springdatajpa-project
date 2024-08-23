package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "hello my fist ";
  }

  @PostMapping("/post-order")
  public String post(@RequestBody Order order) {

    return "Request accepted and message is : " + order.toString();
  }


  //http://localhost:8080/hello/olzhas
  @GetMapping("/hello/{user-name}")
  public String pathVar(
     @PathVariable("user-name") String userName
  ) {
    return "my value equals= " + userName;
  }

//  //http://localhost:8080/hello?param_name=paramvalue7param_name2=param_value2
//  @GetMapping("/hello")
//  public String paramVar(
//      @RequestParam("user-name") String userName,
//      @RequestParam("user-lastname") String lastname
//  ) {
//    return "my value equals= " + userName + " " + lastname;
//  }
}

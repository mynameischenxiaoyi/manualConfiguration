package com.yichen.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 陈易chenyi01
 * @version 1.0
 * @date 2021/2/4 7:32 下午 phone 13172680119
 */
@RestController
@RequestMapping("/v1")
public class PersonController1 {

  @GetMapping("/hello")
  public String gteHello(){
    return "hello";
  }
}

package com.bkit.controller;

import static com.bkit.controller.endpoint.AppEndpoint.HELLO_ENDPOINT;

import com.bkit.services.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HELLO_ENDPOINT)
@RequiredArgsConstructor
public class HelloController {

  private final HelloService helloService;

  @GetMapping
  public String hello() {
    return helloService.hello();
  }
}

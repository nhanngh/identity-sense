package com.bkit.services.impl;

import com.bkit.config.AppConfig;
import com.bkit.services.HelloService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceImpl implements HelloService {

  private final AppConfig appConfig;

  @Override
  public String hello() {
    return Objects.isNull(appConfig.getHelloWord()) ? "Hello word 1!" : appConfig.getHelloWord() ;
  }
}

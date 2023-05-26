package com.bkit.config;

import static com.bkit.constants.StringConstants.APP_CONFIG;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = APP_CONFIG)
@Validated
public class AppConfig {

  private final String helloWord;
}

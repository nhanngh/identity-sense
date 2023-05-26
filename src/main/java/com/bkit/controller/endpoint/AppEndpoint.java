package com.bkit.controller.endpoint;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AppEndpoint {

  public static final String VERSION = "/v1";

  public static final String HELLO_ENDPOINT = VERSION + "/hello";
  public static final String USER = VERSION + "/users";
  public static final String CCCD = "/cccd";
  public static final String QR_CODES_SCAN = CCCD + "/qr-codes/scan";
  public static final String QR_CODES_SCAN2 = CCCD + "/qr-codes/scan2";
}

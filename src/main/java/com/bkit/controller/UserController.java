package com.bkit.controller;

import com.bkit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.bkit.controller.endpoint.AppEndpoint.QR_CODES_SCAN;
import static com.bkit.controller.endpoint.AppEndpoint.QR_CODES_SCAN2;
import static com.bkit.controller.endpoint.AppEndpoint.USER;

@RequestMapping(USER)
@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping(QR_CODES_SCAN)
  public String getQRCodeContent(@RequestParam("frontCCCDImage") MultipartFile frontCCCDImage) {
    return userService.getQRCodeContent(frontCCCDImage);
  }

  @PostMapping(QR_CODES_SCAN2)
  public String getQRCodeContent2(@RequestParam("frontCCCDImage") MultipartFile frontCCCDImage) {
    return userService.getQRCodeContentFromBigImage(frontCCCDImage);
  }
}

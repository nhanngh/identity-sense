package com.bkit.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {
  String getQRCodeContent(MultipartFile frontCCCDImage);

  String getQRCodeContentFromBigImage(MultipartFile frontCCCDImage);
}

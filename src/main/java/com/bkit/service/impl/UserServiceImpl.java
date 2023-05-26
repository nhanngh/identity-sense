package com.bkit.service.impl;


import com.bkit.service.UserService;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.qrcode.QRCodeMultiReader;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  @Override
  public String getQRCodeContent(MultipartFile frontCCCDImage) {
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(frontCCCDImage.getBytes());
      BufferedImageLuminanceSource bufferedImageLuminanceSource =
          new BufferedImageLuminanceSource(ImageIO.read(byteArrayInputStream));
      HybridBinarizer hybridBinarizer = new HybridBinarizer(bufferedImageLuminanceSource);
      BinaryBitmap binaryBitmap = new BinaryBitmap(hybridBinarizer);

      Map<DecodeHintType, Object> tmpHintsMap = new EnumMap<>(DecodeHintType.class);

      MultiFormatReader multiFormatReader = new MultiFormatReader();
      Result result = multiFormatReader.decode(binaryBitmap, tmpHintsMap);
      log.info("QR Code Content: {}", result.getText());

      return result.getText();
    } catch (IOException ex) {
      log.error("File is null", ex.getCause());
    } catch (NotFoundException e) {
      throw new RuntimeException(e);
    }

    return null;
  }

  @Override
  public String getQRCodeContentFromBigImage(MultipartFile frontCCCDImage) {
    try {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(frontCCCDImage.getBytes());
      BufferedImage image = ImageIO.read(byteArrayInputStream);

      LuminanceSource source = new BufferedImageLuminanceSource(image);
      BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

      QRCodeMultiReader reader = new QRCodeMultiReader();
      final Result[] rs = reader.decodeMultiple(bitmap);
//      Result result = reader.decode(bitmap);

      BitMatrix matrix = new HybridBinarizer(source).getBlackMatrix();
      com.google.zxing.qrcode.detector.Detector detektiv = new com.google.zxing.qrcode.detector.Detector(matrix);
      DetectorResult detResult = detektiv.detect();

//      String qrCodeText = reader.getText();
//      System.out.println("QR Code text: " + qrCodeText);
    } catch (IOException ex) {
      log.error("File is null", ex.getCause());
    } catch (NotFoundException e) {
      throw new RuntimeException(e);
    } catch (FormatException e) {
      throw new RuntimeException(e);
    }

    return null;
  }
}

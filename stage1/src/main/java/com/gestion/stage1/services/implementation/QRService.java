package com.gestion.stage1.services.implementation;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class QRService {

    public byte[] generateQRCode(String id) {
        try {
            // Generate the QR code with ID, date, and time information
            String qrCodeData = "ID: " + id + "\nDate: " + getCurrentDate() + "\nTime: " + getCurrentTime();
            int width = 300;
            int height = 300;
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, width, height);

            // Convert the BitMatrix to a PNG image
            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int rgb = bitMatrix.get(x, y) ? 0x000000 : 0xFFFFFF;
                    bufferedImage.setRGB(x, y, rgb);
                }
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            // Handle exceptions if necessary
            return null;
        }
    }

    private String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return now.format(formatter);
    }

    private String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }
}

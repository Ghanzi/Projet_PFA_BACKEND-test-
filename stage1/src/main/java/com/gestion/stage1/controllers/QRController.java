package com.gestion.stage1.controllers;

import com.gestion.stage1.services.implementation.QRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class QRController {

    @Autowired
    QRService qrService;

    @GetMapping("/qrcode/{id}")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable("id") String id) {
        byte[] qrCodeImage = qrService.generateQRCode(id);
        if (qrCodeImage != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity<>(qrCodeImage, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

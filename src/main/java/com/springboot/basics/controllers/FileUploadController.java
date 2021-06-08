package com.springboot.basics.controllers;

import com.springboot.basics.Helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());

//        Validation
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request Must Contain File");
        }

        if (!file.getContentType().equals("image/png")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only png File Allowed");
        }

//        File Upload Code
        boolean f = fileUploadHelper.uploadFile(file);
        if (f) {
            System.out.println("Upload Success");
//            return ResponseEntity.ok("Upload Success");
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
        } else {
            System.out.println("Poapat Ho Gaya");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Poapat Ho Gaya");
        }
    }
}

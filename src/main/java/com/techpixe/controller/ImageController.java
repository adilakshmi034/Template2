package com.techpixe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.techpixe.entity.Image;
import com.techpixe.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController
{
	@Autowired
	private ImageService imageService;
	
	@PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(@RequestParam MultipartFile file,
                                             @RequestParam("type") String type) {
        Image image = imageService.uploadImage(file, type);
        return new ResponseEntity<>(image, HttpStatus.CREATED);
    }
}

package com.techpixe.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.techpixe.entity.Image;



public interface ImageService 
{
//	public Image uploadImageToFileSystem(MultipartFile file, Long event) throws IOException;
//
//	public byte[] getImageById(Long id) throws IOException;
	
	Image uploadImage(MultipartFile file, String type);
}

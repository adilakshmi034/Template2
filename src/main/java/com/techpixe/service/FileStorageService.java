package com.techpixe.service;



import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService 
{
	String uploadImageToFileSystem(MultipartFile file) throws IOException;
	
	byte[] downloadImageFromFileSystem(String fileName) throws IOException;
}

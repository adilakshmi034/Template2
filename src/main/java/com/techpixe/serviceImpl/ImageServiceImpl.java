package com.techpixe.serviceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techpixe.entity.Image;
import com.techpixe.repository.ImageRepository;
import com.techpixe.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService
{
	@Autowired
	private ImageRepository imageRepository;

	@Override
    public Image uploadImage(MultipartFile file, String type) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("your-upload-directory" + file.getOriginalFilename());
            Files.write(path, bytes);

            Image image = new Image();
            image.setType(type);
            image.setFilePath(path.toString());
            return imageRepository.save(image);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload image");
        }
    }

	

}

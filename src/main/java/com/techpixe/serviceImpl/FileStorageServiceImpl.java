package com.techpixe.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techpixe.entity.FileData;
import com.techpixe.repository.FileDataRepository;
import com.techpixe.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService
{
	
	
	@Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH="C://Users//pc//Desktop";

//	@Override
//	public String uploadImageToFileSystem(MultipartFile file) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public byte[] downloadImageFromFileSystem(String fileName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData=fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

}

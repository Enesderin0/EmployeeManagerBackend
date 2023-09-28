package com.EmployeeManager.EmployeeManager.services;

import com.EmployeeManager.EmployeeManager.entities.Image;
import com.EmployeeManager.EmployeeManager.repos.ImageRepository;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
public class ImageService {

    ImageRepository imageRepository;

    public Image saveImage(MultipartFile multipartFile) throws Exception{
        Image image =new Image(
                multipartFile.getOriginalFilename(),
                multipartFile.getContentType(),
                multipartFile.getBytes()
        );
        return imageRepository.save(image);
    }

    public byte[] getOneImage(Long id) {
        imageRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("image with " + id + " doesn't exist"));
        return imageRepository.findById(id).get().getFile();
    }

}

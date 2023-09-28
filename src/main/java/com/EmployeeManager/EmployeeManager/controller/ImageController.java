package com.EmployeeManager.EmployeeManager.controller;

import com.EmployeeManager.EmployeeManager.services.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@AllArgsConstructor
public class ImageController {

    private ImageService imageService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveImage(@RequestParam("image")MultipartFile file){
        try{
            this.imageService.saveImage(file);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(file.getOriginalFilename());
    }

    @GetMapping("/{id}")
    public HttpEntity<byte[]> getImage(@PathVariable Long id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(imageService.getOneImage(id), httpHeaders, HttpStatus.OK);
    }

}

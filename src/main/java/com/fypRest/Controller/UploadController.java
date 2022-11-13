package com.fypRest.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@RestController
@RequestMapping("/uploadImage")
public class UploadController {

    @CrossOrigin
    @PostMapping("/picture")
    public boolean pictureUpload(@RequestParam("file") MultipartFile file) {

        return false;
//        System.out.println(file.getName());
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//
//        try {
//            Path downloadedFile = Paths.get(file.getOriginalFilename());
//            Files.deleteIfExists(downloadedFile);
//
//            Files.copy(file.getInputStream(), downloadedFile);
//
//            return true;
//        }
//        catch (IOException e) {
//            LoggerFactory.getLogger(this.getClass()).error("pictureupload", e);
//            return false;
//        }

    }


    @PostMapping("/uploadPicture")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException
    {
        return null;
    }

    @GetMapping(value = "/downloadPicture/{file}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("file") String file) throws IOException {

        System.out.println("file: " + file);
        String path = System.getProperty("user.dir")+ "\\assets\\" + file;
        System.out.println("path : " + path);
        File file1 = new File(path);
        BufferedImage image = ImageIO.read(file1);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        byte[] bytes = baos.toByteArray();

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
}
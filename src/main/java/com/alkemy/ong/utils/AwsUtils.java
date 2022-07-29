package com.alkemy.ong.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


@Service
public class AwsUtils {

<<<<<<< HEAD
    public static File convertMultiPartToFile(MultipartFile file) throws IOException {
=======

    public File convertMultiPartToFile(MultipartFile file) throws IOException {
>>>>>>> e70d55a0906b4a3d3e71266d37f329bec8cc3228

        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


}

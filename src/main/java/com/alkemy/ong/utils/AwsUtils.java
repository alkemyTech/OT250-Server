package com.alkemy.ong.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class AwsUtils {

    public static File convertMultiPartToFile(MultipartFile file) throws IOException {
        // aqui obtenemos el nombre del archivo
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    public static String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }

    public static String getFileUrl(String endPoint, String bucketName, String fileName) {
        return endPoint + "/" + bucketName + "/" + fileName;
    }
}

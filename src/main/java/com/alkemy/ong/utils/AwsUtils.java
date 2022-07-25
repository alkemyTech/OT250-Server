package com.alkemy.ong.utils;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
public class AwsUtils {

    /**
     * aqui podriamos enviar a un mapper para convertir un MultipartFDile en File
     */
    public static File convertMultiPartToFile(MultipartFile file) throws IOException {

        // aqui obtenemos el nombre del archivo file
        File nameFile = new File(file.getOriginalFilename());
        // aqui creamos un fileOut(fichero de salida) con el name
        FileOutputStream fileOut = new FileOutputStream(nameFile);
        //aqui sobreescribimos el fileOut con los bytes
        fileOut.write(file.getBytes());
        // aqui cerramos el fichero
        fileOut.close();

        return nameFile;
    }

    public File write(MultipartFile file, Path dir) {
        Path filepath = Paths.get(dir.toString(), file.getOriginalFilename());

        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//
//    public static String generateFileName(MultipartFile multiPart) {
//        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
//    }
//
//    public static String getFileUrl(String endPoint, String bucketName, String fileName) {
//        return endPoint + "/" + bucketName + "/" + fileName;
//    }
}

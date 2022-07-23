package com.alkemy.ong.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AwsService {

    String uploadFile (MultipartFile multipartFile) throws IOException;

    String file2Base64 (String base64) throws IOException;


}

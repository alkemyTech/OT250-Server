package com.alkemy.ong.service;

import java.io.IOException;

public interface AwsService {
    String uploadFileFromBase64 (String base64) throws IOException;

}

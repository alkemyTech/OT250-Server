package com.alkemy.ong.service.impl;

import com.alkemy.ong.service.AwsService;
import com.alkemy.ong.utils.AwsUtils;
import com.alkemy.ong.utils.MultiPartFileClass;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AwsServiceImpl implements AwsService {

    @Value("${spring.aws.s3.bucket}")
    private String bucket;

    @Value("${spring.aws.s3.endpoint}")
    private String endPoint;

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private AwsUtils awsUtils;


    @Override
    public String uploadFile(MultipartFile multipartFile) throws IOException {

        File fileCreated = awsUtils.multiPartFile2File(multipartFile); //TODO AwsUtils crear método para convertir MultipartFile a File
        String fileName = awsUtils.fileNameGenerator(multipartFile); //TODO AwsUtils crear método para generar el nombre del File
        this.uploadFile2Asw3(fileName,fileCreated);
        fileCreated.delete();
        String url = awsUtils.getUrlFile(endPoint, bucket, fileName); //TODO AwsUtils crear método para generar el url

        return url;
    }

    @Override
    public String file2Base64(String base64) throws IOException {

        String[] parts = base64.split(",");
        String header = parts[0];
        String contents = parts[1];
        MultipartFile multipartFile = new MultiPartFileClass(header, contents);

        return uploadFile(multipartFile);
    }

    public void uploadFile2Asw3 (String fileName, File file){

        this.amazonS3.putObject(new PutObjectRequest(bucket,fileName,file)
                                .withCannedAcl(CannedAccessControlList.PublicRead));

    }
}

package com.alkemy.ong.utils;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class MultiPartFileClass implements MultipartFile {

    private final byte[] FILE_CONTENT;
    private final String EXTENSION;
    private final String TYPE;

    public MultiPartFileClass (String header,String contents){

        this.FILE_CONTENT = Base64.getDecoder().decode(contents.getBytes(StandardCharsets.UTF_8));
        this.EXTENSION = header.split(";")[0].split("/")[1];
        this.TYPE = header.split(";")[0].split(":")[1];
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getOriginalFilename() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return FILE_CONTENT;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(FILE_CONTENT);
    }

    @Override
    public Resource getResource() {
        return MultipartFile.super.getResource();
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {

    }


}

package com.alkemy.ong.utils;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;


public class MultiPartFileClass implements MultipartFile {

    private final byte[] FILE_CONTENT;
    private final String EXTENSION;
    private final String TYPE;
    private final String FILE_NAME;

    public MultiPartFileClass (String header,String contents){
        this.FILE_CONTENT = Base64.getDecoder().decode(contents.getBytes(StandardCharsets.UTF_8));
        this.EXTENSION = header.split(";")[0].split("/")[1];
        this.TYPE = header.split(";")[0].split(":")[1];
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        this.FILE_NAME = formatter.format(date).toString();
    }

    @Override
    public String getName() {
        return this.FILE_NAME;

    }

    @Override
    public String getOriginalFilename() {

        return this.FILE_NAME+"."+this.EXTENSION;

    }

    @Override
    public String getContentType() {
        return this.TYPE;

    }

    @Override
    public boolean isEmpty() {

        return this.FILE_CONTENT.length == 0 || this.FILE_CONTENT == null;

    }

    @Override
    public long getSize() {

        return this.FILE_CONTENT.length;
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

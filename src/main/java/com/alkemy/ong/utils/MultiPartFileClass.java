package com.alkemy.ong.utils;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class MultiPartFileClass implements MultipartFile {
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
        return new byte[0];
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public Resource getResource() {
        return MultipartFile.super.getResource();
    }

    @Override
    public void transferTo(File file) throws IOException, IllegalStateException {

    }

    @Override
    public void transferTo(Path dest) throws IOException, IllegalStateException {
        MultipartFile.super.transferTo(dest);
    }
}

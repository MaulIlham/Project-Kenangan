package com.projectkenangan.ciladarawedding.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUtilService {
    public Resource read(String filename, int flag);
    public String uploads(String id, MultipartFile file,int flag) throws IOException;
}

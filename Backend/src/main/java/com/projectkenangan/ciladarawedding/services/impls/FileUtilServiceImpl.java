package com.projectkenangan.ciladarawedding.services.impls;

import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUtilServiceImpl implements FileUtilService {
    private final Path storageLocation = Paths.get("uploads").toAbsolutePath().normalize();

    @Override
    public Resource read(String filename, int flag) {
        String exceptionMessage=String.format(Constant.FILENOTFOUNDMESSAGE);
        try {
            Path file = storageLocation.resolve(String.format(Constant.IMAGESOURCE,filename)).normalize();
            Resource resource=new UrlResource(file.toUri());
            if(!resource.exists())throw new ResponseStatusException(HttpStatus.NOT_FOUND,exceptionMessage);
            return resource;
        }catch (MalformedURLException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,exceptionMessage);
        }
    }

    @Override
    public String uploads(String id, MultipartFile file, int flag) throws IOException {
        File upload = new File(String.format(Constant.IMAGESOURCE,id));
        file.transferTo(upload);
        return id;
    }
}

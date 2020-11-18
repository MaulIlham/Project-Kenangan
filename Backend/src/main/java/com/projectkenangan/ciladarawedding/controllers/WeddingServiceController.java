package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.entities.WeddingServices;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import com.projectkenangan.ciladarawedding.services.WeddingServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/weddingservice")
public class WeddingServiceController {
    @Autowired
    WeddingServiceService weddingServiceService;

    @Autowired
    FileUtilService fileUtilService;

    @GetMapping()
    public List<WeddingServices> getAllDataWeddingService(){
        return weddingServiceService.getAllData();
    }

    @GetMapping("/{id}")
    public WeddingServices getDataWeddingServiceById(@PathVariable String id){
        return weddingServiceService.getDataById(id);
    }

    @GetMapping("/image/{path}")
    public ResponseEntity<Resource> getFileImage(@PathVariable String path, HttpServletRequest request){
        WeddingServices weddingServices=weddingServiceService.getDataById(path);
        if(weddingServices==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        Resource resource= fileUtilService.read(weddingServices.getId(),0);
        String contentType=null;
        try {
            contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+resource.getFilename()+"\"")
                .body(resource);
    }

    @PostMapping()
    public WeddingServices saveDataWeddingService(@RequestPart MultipartFile[] fileImage, @RequestPart String data)throws IOException {
        return weddingServiceService.saveData(data,fileImage);
    }

    @PutMapping()
    public WeddingServices updateDataWeddingService(@RequestPart MultipartFile[] fileImage, @RequestPart String data)throws IOException{
        return weddingServiceService.saveData(data,fileImage);
    }

    @DeleteMapping("/{id}")
    public void deleteDataWeddingServiceById(@PathVariable String id){
        weddingServiceService.deleteDataById(id);
    }
}

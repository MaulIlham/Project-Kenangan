package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.Beauty;
import com.projectkenangan.ciladarawedding.services.BeautyService;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
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
@RequestMapping("/api/beauty")
public class BeautyController {
    @Autowired
    BeautyService beautyService;

    @Autowired
    FileUtilService fileUtilService;

    @GetMapping("")
    public List<Beauty> getAllDataBeauty(){
        return beautyService.getAllData();
    }

    @GetMapping("/{id}")
    public Beauty getDataBeautyById(@PathVariable String id){
        return beautyService.getDataById(id);
    }

    @GetMapping("/image/{path}")
    public ResponseEntity<Resource> getFileImage(@PathVariable String path, HttpServletRequest request){
        Beauty beauty=beautyService.getDataById(path);
        if(beauty==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        Resource resource= fileUtilService.read(beauty.getId(),0);
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

    @PostMapping("")
    public Beauty saveDataBeauty(@RequestPart MultipartFile fileImage, @RequestPart String data) throws IOException {
        return beautyService.saveData(data,fileImage);
    }

    @PutMapping("")
    public Beauty updateDataBeauty(@RequestPart MultipartFile fileImage, @RequestPart String data)throws IOException{
        return beautyService.saveData(data,fileImage);
    }

    @DeleteMapping("/{id}")
    public void deleteDataBeautyById(@PathVariable String id){
        beautyService.deleteDataById(id);
    }
}

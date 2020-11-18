package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.Beauty;
import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.services.DressApparelService;
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
@CrossOrigin
@RequestMapping("/api/dressapparel")
public class DressApparelCotroller {
    @Autowired
    DressApparelService dressApparelService;

    @Autowired
    FileUtilService fileUtilService;

    @GetMapping()
    public List<DressApparel> getAllDataDressApparel(){
        return dressApparelService.getAllData();
    }

    @GetMapping("/{id}")
    public DressApparel getDataDressApparelById(@PathVariable String id){
        return dressApparelService.getDataById(id);
    }

    @GetMapping("/image/{path}")
    public ResponseEntity<Resource> getFileImage(@PathVariable String path, HttpServletRequest request){
        DressApparel dressApparel=dressApparelService.getDataById(path);
        if(dressApparel==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        Resource resource= fileUtilService.read(dressApparel.getId(),0);
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
    public DressApparel saveDataDressApparel(@RequestPart MultipartFile[] fileImage, @RequestPart String data)throws IOException{
        return dressApparelService.saveData(data,fileImage);
    }

    @PutMapping()
    public DressApparel updateDataDressApparel(@RequestPart MultipartFile[] fileImage, @RequestPart String data)throws IOException {
        return dressApparelService.saveData(data,fileImage);
    }

    @DeleteMapping("/{id}")
    public void deleteDataDressApparelById(@PathVariable String id){
        dressApparelService.deleteDataById(id);
    }
}

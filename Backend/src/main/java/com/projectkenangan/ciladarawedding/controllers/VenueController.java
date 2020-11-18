package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.entities.Venue;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import com.projectkenangan.ciladarawedding.services.VenueService;
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
@RequestMapping("/api/venue")
public class VenueController {
    @Autowired
    VenueService venueService;

    @Autowired
    FileUtilService fileUtilService;

    @GetMapping()
    public List<Venue> getAllDataVenue(){
        return venueService.getAllData();
    }

    @GetMapping("/{id}")
    public Venue getDataVenueById(@PathVariable String id){
        return venueService.getDataById(id);
    }

    @GetMapping("/image/{path}")
    public ResponseEntity<Resource> getFileImage(@PathVariable String path, HttpServletRequest request){
        Venue venue=venueService.getDataById(path);
        if(venue==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        Resource resource= fileUtilService.read(venue.getId(),0);
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
    public Venue saveDataVenue(@RequestPart MultipartFile[] fileImage, @RequestPart String data)throws IOException {
        return venueService.saveData(data,fileImage);
    }

    @PutMapping()
    public Venue updateDataVenue(@RequestPart MultipartFile[] fileImage, @RequestPart String data)throws IOException{
        return venueService.saveData(data,fileImage);
    }

    @DeleteMapping("/{id}")
    public void deleteDataVenueById(@PathVariable String id){
        venueService.deleteDataById(id);
    }
}

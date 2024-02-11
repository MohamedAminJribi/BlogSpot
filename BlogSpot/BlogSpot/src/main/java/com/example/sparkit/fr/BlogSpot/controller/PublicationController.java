package com.example.sparkit.fr.BlogSpot.controller;

import com.example.sparkit.fr.BlogSpot.Dto.PublicationDto;
import com.example.sparkit.fr.BlogSpot.entity.Publication;
import com.example.sparkit.fr.BlogSpot.info.PublicationInfo;
import com.example.sparkit.fr.BlogSpot.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/publication")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @PostMapping(path= "/save")
    public ResponseEntity<Publication>  addPublication(@RequestBody PublicationDto publicationDto){
        Publication addPublication = publicationService.addPublication(publicationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addPublication);}
    @GetMapping("all")
    public List<PublicationInfo> findAllPublications() {
        return publicationService.findAllPublications();}
    @GetMapping("{id}")
    public PublicationInfo findPublications(@PathVariable(value = "id")Long id) {
        return publicationService.findPublications(id);}
    @PutMapping("update")
    public Publication updatePublication(@RequestBody PublicationDto publicationDto){

        return publicationService.updatePublication (publicationDto) ;}
    @DeleteMapping("{id}")
    public String deletePublication(@PathVariable Long id) {

        return publicationService.deletePublication(id);}




}

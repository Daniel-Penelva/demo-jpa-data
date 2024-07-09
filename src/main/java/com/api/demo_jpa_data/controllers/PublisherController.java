package com.api.demo_jpa_data.controllers;

import com.api.demo_jpa_data.dtos.PublisherRecordDto;
import com.api.demo_jpa_data.models.PublisherModel;
import com.api.demo_jpa_data.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    // http://localhost:8080/publisher/save
    @PostMapping("/save")
    public ResponseEntity<PublisherModel> savePublisher(@RequestBody PublisherRecordDto publisherRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(publisherService.savePublisher(publisherRecordDto));
    }

    // http://localhost:8080/publisher/all
    @GetMapping("/all")
    public ResponseEntity<List<PublisherModel>> getAllPublisher(){
        return ResponseEntity.status(HttpStatus.OK).body(publisherService.getAllPublisher());
    }
}

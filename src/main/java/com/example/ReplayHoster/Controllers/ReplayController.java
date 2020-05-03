package com.example.ReplayHoster.Controllers;

import com.example.ReplayHoster.Entities.Replay;
import com.example.ReplayHoster.Services.ReplayService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.elasticsearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;

@RestController
public class ReplayController {

    private ReplayService service;

    @Autowired
    public ReplayController(ReplayService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createReplay(@RequestBody Replay document) throws Exception {
        return new ResponseEntity(service.createReplay(document), HttpStatus.CREATED);
    }

    @GetMapping("/findall")
    public List<Replay> findAll() throws Exception {

        return service.findAll();
    }

}

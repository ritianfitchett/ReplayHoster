package com.example.ReplayHoster.Controllers;

import com.example.ReplayHoster.Entities.Replay;
import com.example.ReplayHoster.Services.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.elasticsearch.action.support.WriteRequest.RefreshPolicy.IMMEDIATE;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/replay/v1")
public class ReplayController {

    private ReplayService service;

    @Autowired
    public ReplayController(ReplayService service){
        this.service = service;
    }

    @PostMapping("/submit")
    public ResponseEntity createReplay(@RequestBody Replay document) throws Exception {
        try {
            return ResponseEntity.ok().body(service.createReplay(document));
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/select")
    public ResponseEntity<List<Replay>> findAll() throws Exception {
        try {
            return ResponseEntity.ok().body(service.findAll());
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}

package com.example.ReplayHoster.Controllers;

import com.example.ReplayHoster.Entities.Replay;
import com.example.ReplayHoster.Services.ReplayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/replay/v1")
public class ReplayController {

    private ReplayService service;

    @Value("${replay.storage.prescan.path}")
    private String replayStoragePreScanPath;

    @Value("${replay.storage.permanent.path}")
    private String replayStoragePermanentPath;

    // Init is required because we are dealing with directory placement.
    // We want our application to create directories if they do not exist.
    @PostConstruct
    public void init(){
        File prescanFile = new File(replayStoragePreScanPath);
        File permanentFile = new File(replayStoragePermanentPath);

        boolean didCreatePrescanDirectory = prescanFile.mkdirs();
        boolean didCreatePermanentDirectory = permanentFile.mkdirs();

        if(didCreatePrescanDirectory) {
            System.out.println("Created the prescan directory.");
        } else {
            System.out.println("Could not create the prescan directory.. Hopefully it exists.");
        }

        if(didCreatePermanentDirectory) {
            System.out.println("Created the permanent directory.");
        } else {
            System.out.println("Could not create the permanent directory.. Hopefully it exists.");
        }

        System.out.println("Completed setup.");
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("HIT");
        System.out.println(replayStoragePreScanPath);
    }

    @PostMapping("/upload")
    public ResponseEntity uploadReplay(@RequestParam("file") MultipartFile file,
                                       @RequestParam("name") String title,
                                       @RequestParam("factions") List<String> factions,
                                       @RequestParam("players") List<String> players,
                                       @RequestParam("competitive") Boolean competetive,
                                       @RequestParam("description") String description)  {
        try {

            /*
              -----
              Notes: May 9th 2020:
                - I've created the ability to upload the file. I've placed it in a configurable prescan directory.
                  Here is where we should virus scan the file.  Afterwards, we should compress it and place that in the
                  permanent storage section / delete the original.
              -----
             */

            File convFile = new File(replayStoragePreScanPath, file.getOriginalFilename());
            // Takes the multipart file & transforms it into a file obj.
            file.transferTo(convFile);

            // --- Here is where the virus scan / compression logic should go.

            // --- Assuming virus scan checks out. We can then place the logic for creating a Replay object here.

            // --- After that, placing the object in ES.

            // --- The next commented line deletes the temporary file created by transfer process.
            //FileUtils.deleteQuietly(convFile.getFile());

            // Done!
            return ResponseEntity.ok().build();
        } catch(Exception e) {
            System.out.println("EXCEPTION: "+e.toString());
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

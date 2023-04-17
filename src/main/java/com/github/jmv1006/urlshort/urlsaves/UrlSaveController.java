package com.github.jmv1006.urlshort.urlsaves;

import com.github.jmv1006.urlshort.urlsaves.apimodels.CreateUrlSaveRequest;
import com.github.jmv1006.urlshort.urlsaves.apimodels.MultipleUrlSavesResponse;
import com.github.jmv1006.urlshort.urlsaves.apimodels.UrlSaveResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class UrlSaveController {

    public final UrlSaveService urlSaveService;

    public UrlSaveController(UrlSaveService urlSaveService) {
        this.urlSaveService = urlSaveService;
    }

    @GetMapping("/url/{url_save_id}")
    public ResponseEntity getUrlSave(@PathVariable String url_save_id) {
        Optional<UrlSaveModel> urlSave = urlSaveService.getUrlSave(url_save_id);

        if(urlSave.isEmpty()) {
            UrlSaveResponse res = new UrlSaveResponse("Could find URL Save.", null);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        UrlSaveResponse res = new UrlSaveResponse("Success", urlSave.get());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/url/user/{user_id}")
    public ResponseEntity getUrlSavesByUser(@PathVariable String user_id) {
        UrlSaveModel[] userSaves = urlSaveService.getUserSaves(user_id);

        MultipleUrlSavesResponse res = new MultipleUrlSavesResponse("Success", userSaves);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/url/create")
    public ResponseEntity createURLSave(@Valid @RequestBody CreateUrlSaveRequest request) {
        // Verify that user id exists
        // Verify that DBModel exists
        UrlSaveModel urlSave = urlSaveService.createUrlSave(request);

        if(urlSave == null) {
            UrlSaveResponse res = new UrlSaveResponse("Could not save url", null);
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        UrlSaveResponse res = new UrlSaveResponse("Successfully Saved URL", urlSave);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}

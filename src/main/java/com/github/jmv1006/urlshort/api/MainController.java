package com.github.jmv1006.urlshort.api;
import com.github.jmv1006.urlshort.urlservice.URLService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@RestController
public class MainController {
    private final Repository myRepo;
    private final URLService myService;

    @Value("${base_url}")
    private String base_url;

    public MainController(Repository myRepo) {
        this.myRepo = myRepo;
        this.myService = new URLService();
    }

    @PostMapping("/create")
    public ResponseEntity createUrl(@Valid @RequestBody RequestModel request) {
        String randomEncoding = myService.encode();

        DBModel mapping = myRepo.findByurl(randomEncoding);

        if(mapping == null) {
            // Checking if inputted url is valid
            try {
                URL u = new URL(request.url); // this would check for the protocol
                u.toURI(); // does the extra checking required for validation of URI

                DBModel newUrlRedirect = new DBModel(randomEncoding, request.url);

                // Saving to DB
                myRepo.save(newUrlRedirect);

                // create a new response model
                ResponseModel res = new ResponseModel(base_url, newUrlRedirect.url, "Success");

                return new ResponseEntity<>(res, HttpStatus.OK);

            } catch (MalformedURLException | URISyntaxException e) {
                ResponseModel res = new ResponseModel(null, null, "Please enter a valid url.");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

            }
        }

        return null;
    }

    @GetMapping("/{encodedId}")
    public ResponseEntity reRoute(@PathVariable String encodedId) throws URISyntaxException {
        DBModel mapping = myRepo.findByurl(encodedId);

        if(mapping == null) {
            ResponseModel res = new ResponseModel(null, null, "URL not found.");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        } else {
            URI redirect = new URI(mapping.redirect);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(redirect);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        }
    }
}

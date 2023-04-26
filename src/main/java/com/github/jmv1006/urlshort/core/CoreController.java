package com.github.jmv1006.urlshort.core;
import com.github.jmv1006.urlshort.core.models.RequestModel;
import com.github.jmv1006.urlshort.core.models.RerouteResponse;
import com.github.jmv1006.urlshort.core.models.CreateRedirectResponse;
import com.github.jmv1006.urlshort.urlservice.URLService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@CrossOrigin
@RestController
public class CoreController {
    private final CoreRepository myRepo;
    private final URLService myService;

    @Value("${base_url}")
    private String base_url;

    public CoreController(CoreRepository myRepo) {
        this.myRepo = myRepo;
        this.myService = new URLService();
    }
    @PostMapping("/core/create")
    public ResponseEntity createUrl(@Valid @RequestBody RequestModel request) {
        String randomEncoding = myService.encode();

        CoreDBModel mapping = myRepo.findByUrl(randomEncoding);

        if(mapping == null) {
            try {

                URL u = new URL(request.url); // this would check for the protocol
                u.toURI(); // does the extra checking required for validation of URI

                // Check if request.url contains "http://" or "https://"
                if (!request.url.contains("http://") && !request.url.contains("https://")) {
                    request.url = "http://" + request.url;
                }

                CoreDBModel newUrlRedirect = new CoreDBModel(randomEncoding, request.url);

                // Saving to DB
                myRepo.save(newUrlRedirect);

                // create a new response model
                CreateRedirectResponse res = new CreateRedirectResponse(newUrlRedirect, "Success");

                return new ResponseEntity<>(res, HttpStatus.OK);

            } catch (MalformedURLException | URISyntaxException e) {
                CreateRedirectResponse res = new CreateRedirectResponse(null, "Please enter a valid url.");
                return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);

            }
        }
        return null;
    }

    @GetMapping("/core/{encodedId}")
    public ResponseEntity reRoute(@PathVariable String encodedId) throws URISyntaxException {
        CoreDBModel urlInfo = myRepo.findByUrl(encodedId);

        if(urlInfo == null) {
            RerouteResponse res = new RerouteResponse(null, "URL not found.");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        } else {
            RerouteResponse res = new RerouteResponse(urlInfo.redirect, "Success");
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }

    @GetMapping("/")
    public String base() {
        return "API Works!";
    }
}

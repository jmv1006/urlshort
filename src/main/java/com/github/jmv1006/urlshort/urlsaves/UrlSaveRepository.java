package com.github.jmv1006.urlshort.urlsaves;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlSaveRepository extends MongoRepository<UrlSaveModel, String> {
    UrlSaveModel[] findByUserId(String userId);

}

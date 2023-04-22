package com.github.jmv1006.urlshort.core;

import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface CoreRepository extends MongoRepository<CoreDBModel, String>{
    CoreDBModel findByUrl(String url);

}
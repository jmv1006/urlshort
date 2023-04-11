package com.github.jmv1006.urlshort.api;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<DBModel, String>{
    DBModel findByurl(String url);

}
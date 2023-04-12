package com.github.jmv1006.urlshort.api;

import com.github.jmv1006.urlshort.api.models.DBModel;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<DBModel, String>{
    DBModel findByUrl(String url);

}
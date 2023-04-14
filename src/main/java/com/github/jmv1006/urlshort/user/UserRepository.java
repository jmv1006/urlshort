package com.github.jmv1006.urlshort.user;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel, String> {
}

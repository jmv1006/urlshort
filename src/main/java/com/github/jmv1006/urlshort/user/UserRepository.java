package com.github.jmv1006.urlshort.user;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel, String> {
    UserModel findByUsername(String username);
    Optional<UserModel> findById(String id);


}

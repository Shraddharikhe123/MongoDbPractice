package com.perennialsys.snapshot.repository;

import com.perennialsys.snapshot.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Account,String> {
}

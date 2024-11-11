package com.Dotsquares.LoginTask.Repository;

import com.Dotsquares.LoginTask.Model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel, String>
{

        Optional<UserModel> findByMobileNo(String mobileNo);
}



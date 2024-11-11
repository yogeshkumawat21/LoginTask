package com.Dotsquares.LoginTask.Repository;

import com.Dotsquares.LoginTask.Model.OtpModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OtpRepository extends MongoRepository<OtpModel, String> {
    Optional<OtpModel> findByEmail(String email);
    Optional<OtpModel> findByMobileNo(String mobileNo);

}

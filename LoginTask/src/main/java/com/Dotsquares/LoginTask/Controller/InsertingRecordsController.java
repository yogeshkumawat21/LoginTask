package com.Dotsquares.LoginTask.Controller;

import com.Dotsquares.LoginTask.Dto.UserDto;
import com.Dotsquares.LoginTask.Model.UserModel;
import com.Dotsquares.LoginTask.Repository.UserRepository;
import com.Dotsquares.LoginTask.ServiceImplementation.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class InsertingRecordsController {



    @Autowired
    UserServiceImplementation userServiceImplementation;

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

        String response = String.valueOf(userServiceImplementation.saveUser(userDto));
        return ResponseEntity.ok().body(response);
    }

}

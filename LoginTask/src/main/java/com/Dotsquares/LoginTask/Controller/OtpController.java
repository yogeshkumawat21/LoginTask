package com.Dotsquares.LoginTask.Controller;
import com.Dotsquares.LoginTask.Model.OtpModel;
import com.Dotsquares.LoginTask.Model.UserModel;
import com.Dotsquares.LoginTask.Request.SignInRequest;
import com.Dotsquares.LoginTask.Request.VerifyOtpRequest;
import com.Dotsquares.LoginTask.Repository.UserRepository;
import com.Dotsquares.LoginTask.Service.OtpService;
import com.Dotsquares.LoginTask.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/auth")
public class OtpController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OtpService otpService;

    @Autowired
    private UserService userService;



    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody SignInRequest request) {
        ResponseEntity response= userService.sendOtp(request);
        return response;
    }


    @PostMapping("/verifyOtp")
    public ResponseEntity<?> verifyOtp(@RequestBody VerifyOtpRequest request) {
        ResponseEntity response= userService.verifyOtp(request);
        return response;
    }
}

package com.Dotsquares.LoginTask.Service;

import com.Dotsquares.LoginTask.Dto.UserDto;
import com.Dotsquares.LoginTask.Request.SignInRequest;
import com.Dotsquares.LoginTask.Request.VerifyOtpRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public String saveUser(UserDto userDto);
    public ResponseEntity<String> sendOtp(SignInRequest signInRequest);
    public ResponseEntity<String> verifyOtp(VerifyOtpRequest verifyOtpRequest);
}

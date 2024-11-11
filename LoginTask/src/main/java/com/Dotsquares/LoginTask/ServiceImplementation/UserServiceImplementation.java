package com.Dotsquares.LoginTask.ServiceImplementation;

import com.Dotsquares.LoginTask.Dto.UserDto;
import com.Dotsquares.LoginTask.Model.OtpModel;
import com.Dotsquares.LoginTask.Model.UserModel;
import com.Dotsquares.LoginTask.Repository.UserRepository;
import com.Dotsquares.LoginTask.Request.SignInRequest;
import com.Dotsquares.LoginTask.Request.VerifyOtpRequest;
import com.Dotsquares.LoginTask.Service.OtpService;
import com.Dotsquares.LoginTask.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    OtpService otpService;

    @Override
    public String saveUser(UserDto userDto) {
        Optional<UserModel> existingUser = userRepository.findByMobileNo(userDto.getMobileNo());
        UserModel userModel = new UserModel(userDto);
        if (existingUser.isPresent()) {
            return "User With Mobile No: " + userModel.getMobileNo() + " already exists.";
        } else {
            userRepository.save(userModel);
            return "User created with MobileNO: " + userModel.getMobileNo();
        }
    }

    @Override
    public ResponseEntity<String> sendOtp(SignInRequest request) {
        if (request.getMobileNo() != null) {
            return userRepository.findByMobileNo(request.getMobileNo())
                    .map(user -> {
                        otpService.sendOtp(user.getMobileNo());
                        return ResponseEntity.ok("OTP sent to Mobile Number");
                    })
                    .orElseGet(() -> ResponseEntity.badRequest().body("User with this Mobile Number not found"));
        } else {
            return ResponseEntity.badRequest().body("User Details (Email or MobileNo) are required");
        }

    }

    @Override
    public ResponseEntity<String> verifyOtp(VerifyOtpRequest request) {
        OtpModel otp = otpService.getOtpByEmailOrMobile(request.getEmailOrMobile());

        if (otp != null && otp.getOtp().equals(request.getOtp()) && otp.getExpiresAt().isAfter(LocalDateTime.now())) {
            UserModel user = userRepository.findByMobileNo(request.getEmailOrMobile())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            return ResponseEntity.ok("Otp verified Successfully");
        }
        return ResponseEntity.status(400).body(null);
    }
}


package com.Dotsquares.LoginTask.Service;

import com.Dotsquares.LoginTask.Model.OtpModel;

public interface OtpService {

    public String generateOtp();
    public void sendOtp(String email);
    public OtpModel getOtpByEmailOrMobile(String emailOrMobile);
}

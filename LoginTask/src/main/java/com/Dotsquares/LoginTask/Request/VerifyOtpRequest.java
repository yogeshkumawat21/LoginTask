package com.Dotsquares.LoginTask.Request;

public class VerifyOtpRequest {
        private String emailOrMobile;
        private String otp;

    public VerifyOtpRequest(){};
    public VerifyOtpRequest(String otp, String emailOrMobile) {
        this.otp = otp;
        this.emailOrMobile = emailOrMobile;
    }

    public String getEmailOrMobile() {
        return emailOrMobile;
    }

    public void setEmailOrMobile(String emailOrMobile) {
        this.emailOrMobile = emailOrMobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}

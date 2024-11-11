package com.Dotsquares.LoginTask.Request;

public class SignInRequest {
    private String email;
    private String mobileNo;
    public SignInRequest(){};
    public SignInRequest(String mobileNo, String email) {
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "SignInRequest{" +
                "email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}

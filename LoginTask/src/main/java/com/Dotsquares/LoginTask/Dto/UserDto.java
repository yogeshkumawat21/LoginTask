package com.Dotsquares.LoginTask.Dto;

import com.Dotsquares.LoginTask.Model.UserModel;
import org.springframework.data.annotation.Id;

public class UserDto {
    @Id
    private String id;
    private String email;
    private String mobileNo;
    private String mpin;
    private boolean fingerprint;
    private boolean face;
    private int customerId;
    public UserDto(){};

    public UserDto(String id, String email, String mobileNo, String mpin, boolean fingerprint, boolean face, int customerId) {
        this.id = id;
        this.email = email;
        this.mobileNo = mobileNo;
        this.mpin = mpin;
        this.fingerprint = fingerprint;
        this.face = face;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMpin() {
        return mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    public boolean isFace() {
        return face;
    }

    public void setFace(boolean face) {
        this.face = face;
    }

    public boolean isFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(boolean fingerprint) {
        this.fingerprint = fingerprint;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", mpin='" + mpin + '\'' +
                ", fingerprint=" + fingerprint +
                ", face=" + face +
                ", customerId=" + customerId +
                '}';
    }
}
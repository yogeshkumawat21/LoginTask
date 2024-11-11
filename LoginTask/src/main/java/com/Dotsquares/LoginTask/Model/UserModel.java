package com.Dotsquares.LoginTask.Model;

import com.Dotsquares.LoginTask.Dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserModel {

    @Id
    private String id;
    private String email;
    private String mobileNo;
    private String mpin;
    private boolean fingerprint;
    private boolean face;
    private int customerId;

    public UserModel(){};

    public UserModel(UserDto userDto){
        this.id = userDto.getId();
        this.mobileNo = userDto.getMobileNo();
        this.email = userDto.getEmail();
        this.fingerprint =userDto.isFingerprint();
        this.mpin = userDto.getMpin();
        this.customerId = userDto.getCustomerId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMpin() {
        return mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    public boolean isFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(boolean fingerprint) {
        this.fingerprint = fingerprint;
    }

    public boolean isFace() {
        return face;
    }

    public void setFace(boolean face) {
        this.face = face;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", mpin='" + mpin + '\'' +
                ", fingerprint=" + fingerprint +
                ", customerId=" + customerId +
                '}';
    }
}




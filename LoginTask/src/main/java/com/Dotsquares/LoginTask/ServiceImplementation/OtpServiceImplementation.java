package com.Dotsquares.LoginTask.ServiceImplementation;

import com.Dotsquares.LoginTask.Model.OtpModel;
import com.Dotsquares.LoginTask.Model.UserModel;
import com.Dotsquares.LoginTask.Repository.OtpRepository;
import com.Dotsquares.LoginTask.Repository.UserRepository;
import com.Dotsquares.LoginTask.Service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpServiceImplementation implements OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserRepository userRepository;

    private static final int OTP_EXPIRATION_MINUTES = 5;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public String generateOtp() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(999999));
    }


    public void sendOtp(String emailOrMobile) {
        String otp = generateOtp();
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime expirationTime = now.plusMinutes(OTP_EXPIRATION_MINUTES);


        OtpModel otpEntity = getOtpByEmailOrMobile(emailOrMobile);

        if (otpEntity != null) {

            otpEntity.setOtp(otp);
            otpEntity.setCreatedAt(now);
            otpEntity.setExpiresAt(expirationTime);
        } else {

            otpEntity = new OtpModel();
            otpEntity.setOtp(otp);
            otpEntity.setCreatedAt(now);
            otpEntity.setExpiresAt(expirationTime);
            otpEntity.setMobileNo(emailOrMobile);

        }

        Optional<UserModel> userOptional = userRepository.findByMobileNo(emailOrMobile);

        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            String emailToSendOtp = user.getEmail();
            otpRepository.save(otpEntity);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(emailToSendOtp);
            message.setSubject("Your OTP Code");
            message.setText("Your OTP code is: " + otp);
            mailSender.send(message);
        }

    }
    public OtpModel getOtpByEmailOrMobile(String emailOrMobile) {
        // Check by email first
        Optional<OtpModel> otpByEmail = otpRepository.findByEmail(emailOrMobile);
        if (otpByEmail.isPresent()) {
            return otpByEmail.get();
        }


        return otpRepository.findByMobileNo(emailOrMobile).orElse(null);
    }
}

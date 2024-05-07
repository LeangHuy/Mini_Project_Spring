package org.example.btb_group_01_spring_mini_project.service.serviceImpl;

import lombok.AllArgsConstructor;
import org.example.btb_group_01_spring_mini_project.exception.BadRequestException;
import org.example.btb_group_01_spring_mini_project.jwt.JwtService;
import org.example.btb_group_01_spring_mini_project.model.dto.request.AppUserRequest;
import org.example.btb_group_01_spring_mini_project.model.dto.request.AuthRequest;
import org.example.btb_group_01_spring_mini_project.model.dto.request.OtpRequest;
import org.example.btb_group_01_spring_mini_project.model.dto.request.PasswordRequest;
import org.example.btb_group_01_spring_mini_project.model.dto.response.AppUserResponse;
import org.example.btb_group_01_spring_mini_project.model.dto.response.AuthResponse;
import org.example.btb_group_01_spring_mini_project.model.entity.AppUser;
import org.example.btb_group_01_spring_mini_project.repository.AppUserRepository;
import org.example.btb_group_01_spring_mini_project.repository.OtpRepository;
import org.example.btb_group_01_spring_mini_project.service.AuthService;
import org.example.btb_group_01_spring_mini_project.service.EmailService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final AppUserRepository appUserRepository;
    private final ModelMapper modelMapper;
    private final EmailService emailService;
    private final OtpRepository otpRepository;
    @Override
    public AuthResponse login(AuthRequest authRequest) throws Exception {
        return null;
    }

    @Override
    public AppUserResponse register(AppUserRequest appUserRequest) throws Exception {
        if (!appUserRequest.getConfirmPassword().equals(appUserRequest.getPassword())){
            throw new BadRequestException("Your confirm password does not match with your password");
        }
        AppUser user = appUserRepository.findByEmail(appUserRequest.getEmail());
        if (user != null) {
            throw new BadRequestException("This email is already registered");
        }
        appUserRequest.setPassword(passwordEncoder.encode(appUserRequest.getPassword()));
        AppUser appUser = appUserRepository.register(appUserRequest);
        String optCode = generateOTP();
        otpRepository.saveOpt(new OtpRequest(
                optCode,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(1L),
                false,
                appUser.getUserId()
        ));
        emailService.sendMail(optCode, appUserRequest.getEmail());
        return modelMapper.map(appUser, AppUserResponse.class);
    }

    @Override
    public void verify(String optCode) {

    }

    @Override
    public void resend(String email) throws Exception {

    }

    @Override
    public void forget(String email, PasswordRequest passwordRequest) {

    }

    @Override
    public UUID findCurrentUser() {
        return null;
    }

    public static String generateOTP() {
        // declare randomNo to store the otp
        // generate 4 digits otp
        int randomNo = (int) (Math.random() * 900000) + 100000;
        // return otp
        return String.valueOf(randomNo);
    }
}

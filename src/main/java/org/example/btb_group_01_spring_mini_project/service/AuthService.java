package org.example.btb_group_01_spring_mini_project.service;

import org.example.btb_group_01_spring_mini_project.model.dto.request.AppUserRequest;
import org.example.btb_group_01_spring_mini_project.model.dto.request.AuthRequest;
import org.example.btb_group_01_spring_mini_project.model.dto.request.PasswordRequest;
import org.example.btb_group_01_spring_mini_project.model.dto.response.AppUserResponse;
import org.example.btb_group_01_spring_mini_project.model.dto.response.AuthResponse;

import java.util.UUID;

public interface AuthService {

    AuthResponse login(AuthRequest authRequest) throws Exception;

    AppUserResponse register(AppUserRequest appUserRequest) throws Exception;

    void verify(String optCode);

    void resend(String email) throws Exception;

    void forget(String email, PasswordRequest passwordRequest);

    UUID findCurrentUser();
}

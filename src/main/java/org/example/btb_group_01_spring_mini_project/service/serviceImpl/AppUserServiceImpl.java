package org.example.btb_group_01_spring_mini_project.service.serviceImpl;

import org.example.btb_group_01_spring_mini_project.repository.AppUserRepository;
import org.example.btb_group_01_spring_mini_project.service.AppUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email);
    }
}

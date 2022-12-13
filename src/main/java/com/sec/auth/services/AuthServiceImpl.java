package com.sec.auth.services;

import com.sec.auth.entities.AppRole;
import com.sec.auth.entities.AppUser;
import com.sec.auth.repositories.AppRoleRepository;
import com.sec.auth.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;

    @Override
    public AppUser addAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addAppRole(AppRole AppRole) {
        return appRoleRepository.save(AppRole);
    }

    @Override
    public void addAppRoleToAppUser(String Username, String RoleName) {
        AppUser appUser = appUserRepository.findByUsername(Username);
        AppRole appRole = appRoleRepository.findByRoleName(RoleName);
        appUser.getRoles().add(appRole);
    }

    @Override
    public AppUser getAppUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }
}

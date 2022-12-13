package com.sec.auth.services;

import com.sec.auth.entities.AppRole;
import com.sec.auth.entities.AppUser;

import java.util.List;

public interface AuthService {
    AppUser addAppUser(AppUser appUser);
    AppRole addAppRole(AppRole appRole);
    void addAppRoleToAppUser(String appUsername, String appRoleName);
    AppUser getAppUserByUsername(String appUsername);
    List<AppUser> getAppUsers();
}

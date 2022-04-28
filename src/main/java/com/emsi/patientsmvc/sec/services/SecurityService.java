package com.emsi.patientsmvc.sec.services;

import com.emsi.patientsmvc.sec.entities.AppRole;
import com.emsi.patientsmvc.sec.entities.AppUser;

public interface SecurityService  {
    AppUser saveNewUser(String username, String password, String verifyPassword);
    AppRole saveNewRole(String roleName, String roleDesc);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);

    AppUser loadUserByUsername(String username);
}

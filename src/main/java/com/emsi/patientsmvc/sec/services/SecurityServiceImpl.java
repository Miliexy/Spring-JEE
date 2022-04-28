package com.emsi.patientsmvc.sec.services;

import com.emsi.patientsmvc.sec.entities.AppRole;
import com.emsi.patientsmvc.sec.entities.AppUser;
import com.emsi.patientsmvc.sec.repositories.AppRoleRepository;
import com.emsi.patientsmvc.sec.repositories.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveNewUser(String username, String password, String verifyPassword) {
        if(!password.equals(verifyPassword)) throw new RuntimeException("Password do not match");
        String hashedPWD = passwordEncoder.encode(password);
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser!=null) throw new RuntimeException("Username " + username + "is already taken!");
        appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setPassword(hashedPWD);
        appUser.setActive(true);
        AppUser savedAppUser = appUserRepository.save(appUser);

        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String roleDesc) {

        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole!=null) throw new RuntimeException("Role" + roleName + "already exists!");
        appRole = new AppRole();
        appRole.setRoleName(roleName);
        appRole.setDescription(roleDesc);

        AppRole savedAppRole = appRoleRepository.save(appRole);

        return savedAppRole;
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser==null) throw new RuntimeException("User not found.");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole==null) throw new RuntimeException("Role not found.");

        appUser.getAppRoleList().add(appRole);


    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if(appUser==null) throw new RuntimeException("User not found.");
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        if(appRole==null) throw new RuntimeException("Role not found.");
        appUser.getAppRoleList().remove(appRole);

    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}

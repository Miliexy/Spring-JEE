package com.emsi.patientsmvc;

import com.emsi.patientsmvc.entities.Address;
import com.emsi.patientsmvc.entities.Doctor;
import com.emsi.patientsmvc.entities.Patient;
import com.emsi.patientsmvc.repositories.AddressRepository;
import com.emsi.patientsmvc.repositories.DoctorRepository;
import com.emsi.patientsmvc.repositories.PatientRepository;
import com.emsi.patientsmvc.sec.services.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            for (int i = 0; i < 10; i++) {
                patientRepository.save(
                        new Patient(null,"Mohammed",new Date(),true,321,null));
                patientRepository.save(
                        new Patient(null,"Yasmine",new Date(),true,110,null));
                patientRepository.save(
                        new Patient(null,"Hanae",new Date(),false,320,
                                new Doctor(null, "ilyasse", "lahrach",30
                                        , new Address(null, "testStreet","testCity","testCountry","testZipCode"))));
            }


          /*  patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });*/
        };
    }

    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("ilyasse", "1234","1234");
            securityService.saveNewUser("anas", "1234","1234");
            securityService.saveNewUser("sara", "1234","1234");
            securityService.saveNewRole("USER","user");
            securityService.saveNewRole("ADMIN","admin");

            securityService.addRoleToUser("ilyasse", "ADMIN");
            securityService.addRoleToUser("ilyasse", "USER");
            securityService.addRoleToUser("sara", "USER");

        };
    }

    //@Bean
    CommandLineRunner saveAddress(AddressRepository addressRepository){
        return args -> {
            addressRepository.save(new Address(null, "testStreet","testCity","testCountry","testZipCode"));
        };
    }
    //@Bean
    CommandLineRunner saveDoctors(DoctorRepository doctorRepository) {

        return args -> {
            doctorRepository.save(new Doctor(null, "ilyasse", "lahrach",30
            , new Address(null, "testStreet","testCity","testCountry","testZipCode")));
        };
    }

}

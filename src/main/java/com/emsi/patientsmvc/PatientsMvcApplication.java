package com.emsi.patientsmvc;

import com.emsi.patientsmvc.entities.Patient;
import com.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            for (int i = 0; i < 10; i++) {
                patientRepository.save(
                        new Patient(null,"Mohammed",new Date(),true,321));
                patientRepository.save(
                        new Patient(null,"Yasmine",new Date(),true,110));
                patientRepository.save(
                        new Patient(null,"Hanae",new Date(),false,320));
            }


            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
    }
}

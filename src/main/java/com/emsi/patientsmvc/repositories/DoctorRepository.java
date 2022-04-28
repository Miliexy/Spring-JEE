package com.emsi.patientsmvc.repositories;

import com.emsi.patientsmvc.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findDoctorByLastName(String lastName);

}

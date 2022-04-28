package com.emsi.patientsmvc.services;

import com.emsi.patientsmvc.entities.Doctor;
import com.emsi.patientsmvc.repositories.DoctorRepository;
import com.emsi.patientsmvc.repositories.PatientRepository;

public class HospitalServicesImpl implements HospitalServices {

    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    @Override
    public void addDoctorToPatient(String doctorName, String patientname) {
        Doctor doctor = doctorRepository.findDoctorByLastName(doctorName);
        if(doctor==null) throw new RuntimeException("Doctor doesn't exist");


    }

    @Override
    public void removeDoctorFromPatient(String doctorName, String patientname) {

    }
}

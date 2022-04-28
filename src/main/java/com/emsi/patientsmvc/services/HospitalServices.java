package com.emsi.patientsmvc.services;

public interface HospitalServices {


    void addDoctorToPatient(String doctorName, String patientname);
    void removeDoctorFromPatient(String doctorName, String patientname);

}

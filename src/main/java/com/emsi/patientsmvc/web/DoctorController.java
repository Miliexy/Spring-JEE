package com.emsi.patientsmvc.web;

import com.emsi.patientsmvc.entities.Doctor;
import com.emsi.patientsmvc.entities.Patient;
import com.emsi.patientsmvc.repositories.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class DoctorController {
    private DoctorRepository doctorRepository;

}

package com.emsi.patientsmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorID;
    private String firstName;
    private String lastName;
    private int age;
    @OneToOne( cascade = CascadeType.ALL)
    private Address address;
    //@OneToMany(fetch = FetchType.EAGER)
    //private List<Patient> patientList = new ArrayList<>();

}

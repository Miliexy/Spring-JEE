package com.emsi.patientsmvc.repositories;

import com.emsi.patientsmvc.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

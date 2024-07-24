package com.meditrack.meditrack.repository;

import com.meditrack.meditrack.entity.Patient;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @NonNull
    Optional<Patient> findById(@NonNull UUID patientId);
}

package com.meditrack.meditrack.model;

import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class PatientModel {

    private UUID patientId ;
    private String patientName ;
    @Pattern(regexp = "^\\\\+91[0-9]{10}$", message = "Invalid phone number")
    private String contactNum ;
    private String gender ;
    private String emailAddress ;
    private String aadharNum ;
    private String address ;
    private String disease ;
    private int age ;
}

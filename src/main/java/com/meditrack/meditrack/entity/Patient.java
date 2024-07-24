package com.meditrack.meditrack.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Patient extends CommonEntityColumns {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID patientId;

    private String patientName;

    @Pattern(regexp = "^\\\\+91[0-9]{10}$", message = "Invalid phone number")
    private String contactNum;

    private String aadharNum;

    private String address;

    private String disease;

    private Date appointmentDate;

    private int age;
}

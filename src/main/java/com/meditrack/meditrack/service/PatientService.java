package com.meditrack.meditrack.service;

import com.meditrack.meditrack.model.PatientModel;
import com.meditrack.meditrack.utils.GenericException;
import com.meditrack.meditrack.utils.GenericResponse;

import java.util.UUID;

public interface PatientService {

    GenericResponse<PatientModel> getPatientById(UUID patientId) throws GenericException;
}

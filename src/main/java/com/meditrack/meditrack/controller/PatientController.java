package com.meditrack.meditrack.controller;


import com.meditrack.meditrack.constant.Constant;
import com.meditrack.meditrack.model.PatientModel;
import com.meditrack.meditrack.service.PatientService;
import com.meditrack.meditrack.utils.GenericException;
import com.meditrack.meditrack.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(Constant.PATIENT_URI)
public class PatientController {

    private final PatientService patientService ;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService ;
    }

    @GetMapping(Constant.PATIENT_BYID)
    public ResponseEntity<GenericResponse<PatientModel>> getPatientById(@RequestParam UUID patientId) throws GenericException {
        GenericResponse<PatientModel> response = patientService.getPatientById(patientId) ;
        return new ResponseEntity<>(response, response.getStatus()) ;
    }
}

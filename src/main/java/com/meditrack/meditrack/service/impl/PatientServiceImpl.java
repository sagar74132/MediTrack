package com.meditrack.meditrack.service.impl;

import com.meditrack.meditrack.entity.Patient;
import com.meditrack.meditrack.model.PatientModel;
import com.meditrack.meditrack.repository.PatientRepository;
import com.meditrack.meditrack.service.PatientService;
import com.meditrack.meditrack.utils.CommonUtil;
import com.meditrack.meditrack.utils.GenericException;
import com.meditrack.meditrack.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final CommonUtil commonUtil ;

    @Autowired
    public PatientServiceImpl(final PatientRepository patientRepository,
                              final CommonUtil commonUtil) {
        this.patientRepository = patientRepository;
        this.commonUtil = commonUtil ;
    }

    @Override
    public GenericResponse<PatientModel> getPatientById(UUID patientId) throws GenericException {

        Patient patient = patientRepository.findById(patientId).orElse(null);

        if (null != patient) {
            PatientModel patientModel = PatientModel.builder()
                    .age(patient.getAge())
                    .patientName(patient.getPatientName())
                    .address(patient.getAddress())
                    .disease(patient.getDisease())
                    .gender(patient.getGender())
                    .emailAddress(patient.getEmailAddress())
                    .aadharNum(patient.getAadharNum())
                    .contactNum(patient.getContactNum())
                    .patientId(patient.getPatientId())
                    .build();
            return GenericResponse.<PatientModel>builder()
                    .data(patientModel)
                    .responseMessage(commonUtil.getMessage("data.fetched.successfully"))
                    .status(HttpStatus.OK)
                    .statusCode(HttpStatus.OK.value())
                    .build() ;
        } else {
            throw new GenericException(commonUtil.getMessage("patient.not.found"), HttpStatus.NOT_FOUND) ;
        }
    }
}

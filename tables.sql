CREATE TABLE "MediTrack".PATIENT (
    patient_id SERIAL PRIMARY KEY,
    patient_name VARCHAR(30) NOT NULL,
    gender VARCHAR(30) NOT NULL,
    email_address VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    contact_num VARCHAR(12) NOT NULL,
    aadhar_num VARCHAR(12) NOT NULL,
    address VARCHAR(35) NOT NULL,
    disease VARCHAR(35) NOT NULL,
    appointment_date DATE NOT NULL,
    age INT NOT NULL
);

CREATE TABLE "MediTrack".DOCTOR (
    doctor_id SERIAL PRIMARY KEY,
    doctor_name VARCHAR(30) NOT NULL,
    gender VARCHAR(30) NOT NULL,
    email_address VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    education VARCHAR(30) NOT NULL,
    specialization VARCHAR(30) NOT NULL,
    working_days VARCHAR(30) NOT NULL
);

CREATE TABLE "MediTrack".ADMIN (
    admin_id SERIAL PRIMARY KEY,
    admin_name VARCHAR(30) NOT NULL,
    gender VARCHAR(30) NOT NULL,
    email_address VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(20) NOT NULL,
    contact_no VARCHAR(12) NOT NULL
);

CREATE TABLE "MediTrack".RECEPTIONIST (
    receptionist_id SERIAL PRIMARY KEY,
    receptionist_name VARCHAR(30) NOT NULL,
    email_address VARCHAR(30) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    contact_no VARCHAR(12) NOT NULL,
    doctor_id INT NOT NULL REFERENCES DOCTOR(doctor_id)
);

CREATE TABLE "MediTrack".RECORD (
    record_id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES PATIENT(patient_id),
    appointment_date DATE NOT NULL,
    appointment_status VARCHAR(30) NOT NULL,
    doctor_id INT NOT NULL REFERENCES DOCTOR(doctor_id)
);

CREATE TABLE "MediTrack".MEDICAL_REPORT (
    report_id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL REFERENCES PATIENT(patient_id),
    medicine_name INT NOT NULL,
    quantity INT NOT NULL,
    doctor_id INT NOT NULL REFERENCES DOCTOR(doctor_id),
    no_of_days INT NOT NULL,
    date DATE NOT NULL,
    dosage INT NOT NULL,
    tests INT NOT NULL
);

CREATE TABLE "MediTrack".AUTHENTICATE (
    email_id VARCHAR(30) NOT NULL PRIMARY KEY,
    key VARCHAR(30) NOT NULL UNIQUE
);


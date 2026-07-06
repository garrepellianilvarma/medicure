package com.staragile.medicure.service;

import com.staragile.medicure.entity.Doctor;
import com.staragile.medicure.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public Doctor registerDoctor(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor updateDoctor(Integer doctorRegNo, Doctor doctor) {

        Doctor existingDoctor = repository.findById(doctorRegNo).orElse(null);

        if (existingDoctor != null) {

            existingDoctor.setDoctorName(doctor.getDoctorName());
            existingDoctor.setSpecialization(doctor.getSpecialization());
            existingDoctor.setHospital(doctor.getHospital());
            existingDoctor.setExperience(doctor.getExperience());
            existingDoctor.setCity(doctor.getCity());
            existingDoctor.setMobileNo(doctor.getMobileNo());

            return repository.save(existingDoctor);
        }

        return null;
    }

    public Doctor searchDoctor(String doctorName) {
        return repository.findByDoctorName(doctorName);
    }

    public String deleteDoctor(Integer doctorRegNo) {

        repository.deleteById(doctorRegNo);

        return "Doctor Deleted Successfully";
    }
}

package com.staragile.medicure.controller;

import com.staragile.medicure.entity.Doctor;
import com.staragile.medicure.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping("/registerDoctor")
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return service.registerDoctor(doctor);
    }

    @PutMapping("/updateDoctor/{doctorRegNo}")
    public Doctor updateDoctor(@PathVariable Integer doctorRegNo,
                               @RequestBody Doctor doctor) {

        return service.updateDoctor(doctorRegNo, doctor);
    }

    @GetMapping("/searchDoctor/{doctorName}")
    public Doctor searchDoctor(@PathVariable String doctorName) {

        return service.searchDoctor(doctorName);
    }

    @DeleteMapping("/deleteDoctor/{doctorRegNo}")
    public String deleteDoctor(@PathVariable Integer doctorRegNo) {

        return service.deleteDoctor(doctorRegNo);
    }
}

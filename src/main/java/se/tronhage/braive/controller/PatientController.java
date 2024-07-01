package se.tronhage.braive.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.tronhage.braive.entity.Patient;
import se.tronhage.braive.entity.Psychologist;
import se.tronhage.braive.service.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all") public List<Patient>getAllPatients(){
        return patientService.getAllPatients();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> editPatient(@PathVariable Long id, @RequestBody Patient updatedPatient) {
        patientService.editPatient(id, updatedPatient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        return patientService.deletePatient(id);
    }

    @GetMapping("/psychologists/recommendations")
    public List<Psychologist> getPsychologistRecommendations() {
        return patientService.getPsychologistRecommendations();
    }
}

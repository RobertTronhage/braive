package se.tronhage.braive.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.tronhage.braive.entity.Psychologist;
import se.tronhage.braive.service.PatientService;
import se.tronhage.braive.service.PsychologistService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/psychologist")
public class PsychologistController {

    private final PsychologistService psychologistService;
    private final PatientService patientService;

    public PsychologistController(PsychologistService psychologistService, PatientService patientService) {
        this.psychologistService = psychologistService;
        this.patientService = patientService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPatient(@RequestBody Psychologist psychologist) {
        psychologistService.addPsychologist(psychologist);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all") public List<Psychologist> getAllPsychologists(){
        return psychologistService.getAllPsychologists();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> editPsychologist(@PathVariable Long id, @RequestBody Psychologist updatedPsychologist) {
        psychologistService.editPsychologist(id, updatedPsychologist);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Long id) {
        return psychologistService.deletePsychologist(id);
    }
}

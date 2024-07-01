package se.tronhage.braive.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.tronhage.braive.entity.Psychologist;
import se.tronhage.braive.repo.PatientRepo;
import se.tronhage.braive.repo.PsychologistRepo;

import java.util.List;
import java.util.Optional;

@Service
public class PsychologistService {

    private final PsychologistRepo psychologistRepo;
    private final PatientRepo patientRepo;

    public PsychologistService(PsychologistRepo psychologistRepo, PatientRepo patientRepo) {
        this.psychologistRepo = psychologistRepo;
        this.patientRepo = patientRepo;
    }

    public ResponseEntity<String> addPsychologist(Psychologist psychologist) {
        psychologistRepo.save(psychologist);
        return ResponseEntity.ok().body("Psychologist with id " + psychologist.getId() + "added successfully");
    }

    public List<Psychologist> getAllPsychologists() {
        return psychologistRepo.findAll();
    }

    public ResponseEntity<String> editPsychologist(Long id, Psychologist updatedPsychologist) {

        Optional<Psychologist> optionalPsychologist = psychologistRepo.findById(id);
        if (optionalPsychologist.isPresent()) {
            Psychologist psychologist = optionalPsychologist.get();

            psychologist.setFirstName(updatedPsychologist.getFirstName());
            psychologist.setLastName(updatedPsychologist.getLastName());
            psychologist.setIdNo(updatedPsychologist.getIdNo());
            psychologist.setDateOfBirth(updatedPsychologist.getDateOfBirth());
            psychologist.setOrg(updatedPsychologist.getOrg());
            psychologist.setPatients(updatedPsychologist.getPatients());

            psychologistRepo.save(psychologist);
            return ResponseEntity.ok().body("Psychologist with id " + psychologist.getId() + " added successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deletePsychologist(Long id) {
        Optional<Psychologist> optionalPerson = psychologistRepo.findById(id);
        if (optionalPerson.isPresent()) {
            psychologistRepo.deleteById(id);
            return ResponseEntity.ok().body("Psychologist with id " + id + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

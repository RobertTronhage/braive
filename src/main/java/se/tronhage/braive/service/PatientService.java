package se.tronhage.braive.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import se.tronhage.braive.entity.Patient;
import se.tronhage.braive.entity.Psychologist;
import se.tronhage.braive.repo.PatientRepo;
import se.tronhage.braive.repo.PsychologistRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    //add new
    //edit
    //delete
    //get recommendations

    private final PatientRepo patientRepo;
    private final PsychologistRepo psychologistRepo;

    public PatientService(PatientRepo patientRepo, PsychologistRepo psychologistRepo) {
        this.patientRepo = patientRepo;
        this.psychologistRepo = psychologistRepo;
    }

    public ResponseEntity<String> addPatient(Patient patient) {
        patientRepo.save(patient);
        return ResponseEntity.ok().body("Patient with id " + patient.getId() + " added successfully");
    }

    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    public ResponseEntity<String> editPatient(Long id, Patient updatedPatient) {
        Optional<Patient> optionalPatient = patientRepo.findById(id);

        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();

            patient.setFirstName(updatedPatient.getFirstName());
            patient.setLastName(updatedPatient.getLastName());
            patient.setIdNo(updatedPatient.getIdNo());
            patient.setDateOfBirth(updatedPatient.getDateOfBirth());
            patient.setOrg(updatedPatient.getOrg());
            patient.setPsychologist(updatedPatient.getPsychologist());

            patientRepo.save(patient);
            return ResponseEntity.ok().body("Patient with id " + id + " updated successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<String> deletePatient(Long id) {
        Optional<Patient> optionalPerson = patientRepo.findById(id);
        if (optionalPerson.isPresent()) {
            patientRepo.deleteById(id);
            return ResponseEntity.ok().body("Psychologist with id " + id + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public List getPsychologistRecommendations() {
        List<Psychologist> allPsychologists = psychologistRepo.findAll();
        List<Psychologist> recommendedPsychologists = new ArrayList();

        int minLoad = Integer.MAX_VALUE;

        for (Psychologist p : allPsychologists) {
            int load = p.getPatients().size();

            if (load < minLoad) {
                recommendedPsychologists.clear();
                recommendedPsychologists.add(p);
                minLoad = load;
            } else if (load == minLoad) {
                recommendedPsychologists.add(p);
            }
        }
        return recommendedPsychologists;
    }
}

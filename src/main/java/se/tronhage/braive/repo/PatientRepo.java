package se.tronhage.braive.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.tronhage.braive.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Long> {

}

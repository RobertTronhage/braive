package se.tronhage.braive.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.tronhage.braive.entity.Psychologist;

@Repository
public interface PsychologistRepo extends JpaRepository<Psychologist,Long> {

}

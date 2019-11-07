package pl.akademiaspring.week8.notes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.akademiaspring.week8.notes.model.Note;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByCreateDateBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}

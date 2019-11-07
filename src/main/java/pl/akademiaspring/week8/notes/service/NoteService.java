package pl.akademiaspring.week8.notes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.akademiaspring.week8.notes.model.Note;
import pl.akademiaspring.week8.notes.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteService {

    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void addNote(Note note) {
        noteRepository.save(note);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> getNotesBetweenDates(LocalDateTime dateFrom, LocalDateTime dateTo) {
        return noteRepository.findByCreateDateBetween(dateFrom, dateTo);
    }

    public void updateNote(Note note){
        Note noteToUpdate = noteRepository.getOne(note.getId());

        noteToUpdate.setContent(note.getContent());
        noteToUpdate.setModifiedDate(LocalDateTime.now());

        noteRepository.save(noteToUpdate);
    }
}

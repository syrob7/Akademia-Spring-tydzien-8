package pl.akademiaspring.week8.notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.akademiaspring.week8.notes.model.Note;
import pl.akademiaspring.week8.notes.service.NoteService;
import pl.akademiaspring.week8.notes.service.QueryHelpObject;
import pl.akademiaspring.week8.notes.validator.NoteValidator;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Controller
public class NoteController {

    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/add-note")
    public String addNote(Model model) {
        model.addAttribute("note", new Note());

        return "addNote";
    }

    @GetMapping("/get-all-notes")
    public String getAllCars(Model model) {
        model.addAttribute("notes", noteService.getAllNotes());

        return "listNotes";
    }

    @GetMapping("/search-notes-creation-date")
    public String searchNotesByCreateDate(Model model) {
        model.addAttribute("queryObject", new QueryHelpObject());

        return "SearchNotesByCreationDate";
    }

    @GetMapping("/get-notes-creation-date")
    public String getNotesByCreationDate(@ModelAttribute("queryObject") QueryHelpObject query, Model model) {

        LocalDateTime dateFrom = query.getDateFrom().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime dateTo = query.getDateTo().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        List<Note> notes = noteService.getNotesBetweenDates(dateFrom, dateTo);
        model.addAttribute("notes", notes);

        return "listNotes";
    }

    @PostMapping("/save-new-note")
    public String saveNewNote(@ModelAttribute Note note, BindingResult result) {

        new NoteValidator().validate(note, result);

        if (result.hasErrors()) {
            return "addNote";
        }

        noteService.addNote(note);

        return "redirect:/get-all-notes";
    }

    @GetMapping("/modifyNotes/{id}")
    public String modifyNoteById(@PathVariable long id, Model model) {
        Optional<Note> first = noteService.getNoteById(id);

        if (first.isPresent()) {
            model.addAttribute("note", first.get());
            return "modifyNote";
        }

        return "redirect:/get-all-notes";
    }

    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute Note note) {
        Optional<Note> first = noteService.getNoteById(note.getId());

        if (first.isPresent()) {
            first.get().setContent(note.getContent());
            first.get().setModifiedDate(LocalDateTime.now());
            noteService.updateNote(first.get());
        }

        return "redirect:/get-all-notes";
    }
}

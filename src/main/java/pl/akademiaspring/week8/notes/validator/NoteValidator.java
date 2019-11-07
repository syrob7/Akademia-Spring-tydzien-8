package pl.akademiaspring.week8.notes.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.akademiaspring.week8.notes.model.Note;

public class NoteValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Note.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Note car = (Note) o;

        ValidationUtils.rejectIfEmpty(errors, "content", "error.content.empty");
    }
}

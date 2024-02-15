package services;

import models.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class NotesService {
    private final List<Note> notes;

    public NotesService() {
        this.notes = new ArrayList<>();
    }

    public void add(Note note) {
        notes.add(note);
    }

    public List<Note> all() {
        return notes;
    }

    public Optional<Note> checkNote(String number) {
        Optional<Note> note = Optional.empty();
        if (new Scanner(number).hasNextInt()) {
            int noteNumber = Integer.parseInt(number);
            if (noteNumber >= 1 && noteNumber <= notes.size()) {
                note = Optional.of(notes.get(noteNumber - 1));
            }
        }
        return note;
    }

    public void edit(Note note, String text) {
        note.setText(text);
    }

    public void delete(Note note) {
        notes.remove(note);
    }
}

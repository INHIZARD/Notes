package controllers;

import models.Note;
import services.NotesService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static views.NotesView.*;

public class NotesController {
    private final BufferedReader br;
    private final NotesService notesService;

    public NotesController() {
        this.notesService = new NotesService();
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String menu() throws IOException {
        showView();
        commandView();
        return br.readLine();
    }

    public String addNote() throws IOException {
        notesService.add(addNoteView(br));
        commandView();
        return br.readLine();
    }

    public String checkNotes() throws IOException {
        checkNotesView(notesService.all());
        commandView();
        return br.readLine();
    }

    public String editNote() throws IOException {
        Optional<Note> note = notesService.checkNote(chooseNoteView(br));
        if (note.isPresent()) {
            notesService.edit(note.get(), editNoteView(br));
        } else {
            errorView();
        }
        commandView();
        return br.readLine();
    }

    public String deleteNote() throws IOException {
        Optional<Note> note = notesService.checkNote(chooseNoteView(br));
        if (note.isPresent()) {
            notesService.delete(note.get());
            deleteNoteView();
        } else {
            errorView();
        }
        commandView();
        return br.readLine();
    }

    public void close() {
        closeView();
    }

    public String error() throws IOException {
        errorView();
        commandView();
        return br.readLine();
    }
}

package controllers;

import models.Note;
import services.NotesService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static views.NotesView.*;

/**
 * Класс, реализующий эндпоинты приложения с помощью класса {@code views.NotesView}
 *
 * @see sessions.Session
 */
public class NotesController {
    private final BufferedReader br;
    private final NotesService notesService;

    public NotesController() {
        this.notesService = new NotesService();
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Меню приложения.
     */
    public String menu() throws IOException {
        showView();
        commandView();
        return br.readLine();
    }

    /**
     * Добавление новой заметки.
     */
    public String addNote() throws IOException {
        notesService.add(addNoteView(br));
        commandView();
        return br.readLine();
    }

    /**
     * Просмотр всех заметок.
     */
    public String checkNotes() throws IOException {
        checkNotesView(notesService.all());
        commandView();
        return br.readLine();
    }

    /**
     * Редактирование заметки.
     */
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

    /**
     * Удаление заметки.
     */
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

    /**
     * Закрытие приложения.
     */
    public void close() {
        closeView();
    }

    /**
     * Сообщение об ошибке.
     */
    public String error() throws IOException {
        errorView();
        commandView();
        return br.readLine();
    }
}

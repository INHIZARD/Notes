package services;

import models.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Класс, реализующий работу с заметками
 */
public class NotesService {
    private final List<Note> notes;

    public NotesService() {
        this.notes = new ArrayList<>();
    }

    /**
     * Добавление новой заметки
     * @param note заметка
     */
    public void add(Note note) {
        notes.add(note);
    }

    /**
     * Просмотр всех заметок
     * @return список всех заметок
     */
    public List<Note> all() {
        return notes;
    }

    /**
     * Проверка номера заметки на наличие её в списке всех заметок
     * @param number номер заметки
     * @return заметка (или {@code null} значение если её нет в списке)
     */
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

    /**
     * Редактирование заметки
     * @param note заметка
     * @param text новый текст заметки
     */
    public void edit(Note note, String text) {
        note.setText(text);
    }

    /**
     * Удаление заметки
     * @param note заметка
     */
    public void delete(Note note) {
        notes.remove(note);
    }
}

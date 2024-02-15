package models;

import java.util.Date;

/**
 * Класс реализующий заметку.
 */
public class Note {
    // Название заметки
    private String title;
    // Текст заметки
    private String text;
    // Дата последнего редактирования заметки
    private Date dateOfLastEdit;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
        newDateOfEdit();
    }

    private void newDateOfEdit() {
        dateOfLastEdit = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        newDateOfEdit();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        newDateOfEdit();
    }

    public Date getDateOfLastEdit() {
        return dateOfLastEdit;
    }

    @Override
    public String toString() {
        return title + " - " + dateOfLastEdit + "\n" + text;
    }
}

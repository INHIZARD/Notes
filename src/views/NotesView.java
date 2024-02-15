package views;

import controllers.NotesController;
import models.Note;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Класс, задающий визуальную часть приложения.
 * @see controllers.NotesController
 */
public class NotesView {
    /**
     * Сообщение об ошибке
     */
    public static void errorView() {
        System.out.println("Ошибка ввода команды!");
    }

    /**
     * Запрос команды от пользователя
     */
    public static void commandView() {
        System.out.print("\nВыберите действие (введите номер): ");
    }

    /**
     * Меню приложения
     * @see NotesController#menu()
     */
    public static void showView() {
        System.out.print("""
                Добро пожаловать в приложение "Заметки"!
                1. Добавить заметку
                2. Просмотреть заметки
                3. Редактировать заметку
                4. Удалить заметку
                5. Выход
                """);
    }

    /**
     * Добавление заметки
     * @see NotesController#addNote()
     */
    public static Note addNoteView(BufferedReader br) throws IOException {
        String title;
        StringBuilder text = new StringBuilder();
        System.out.print("Введите заголовок заметки: ");
        title = br.readLine();
        System.out.println("Введите текст заметки (для завершения введите \"end\"):");
        String tempText = br.readLine();
        while (!tempText.equals("end")) {
            text.append(tempText).append("\n");
            tempText = br.readLine();
        }
        System.out.println("Заметка успешно добавлена!");
        return new Note(title, text.toString());
    }

    /**
     * Просмотр всех заметок
     * @see NotesController#checkNotes()
     */
    public static void checkNotesView(List<Note> notes) {
        System.out.println("Список заметок:");
        if (notes.isEmpty()) {
            System.out.println("(Тут пока ничего нет)");
        }
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i));
        }
    }

    /**
     * Выбор заметки
     */
    public static String chooseNoteView(BufferedReader br) throws IOException {
        System.out.print("Введите номер заметки: ");
        return br.readLine();
    }

    /**
     * Редактирование заметки
     * @see NotesController#editNote()
     */
    public static String editNoteView(BufferedReader br) throws IOException {
        StringBuilder text = new StringBuilder();
        System.out.println("Введите новый текст заметки (для завершения введите \"end\"):");
        String tempText = br.readLine();
        while (!tempText.equals("end")) {
            text.append(tempText).append("\n");
            tempText = br.readLine();
        }
        System.out.println("Заметка успешно отредактирована!");
        return text.toString();
    }

    /**
     * Удаление заметки
     * @see NotesController#deleteNote()
     */
    public static void deleteNoteView() {
        System.out.println("Заметка успешно удалена!");
    }

    /**
     * Закрытие приложения
     * @see NotesController#close()
     */
    public static void closeView() {
        System.out.println("До свидания!");
    }
}

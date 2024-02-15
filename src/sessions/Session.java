package sessions;

import controllers.NotesController;

import java.io.IOException;

/**
 * В классе реализована логика вводимых команд.
 * Также класс взаимодействует с {@code NotesController}.
 */
public class Session {
    private final NotesController notesController;

    public Session() {
        this.notesController = new NotesController();
    }

    /**
     * Пользователь имеет возможность ввести любую команду, но отдача предусмотрена только на некоторые команды:
     * <p>
     *     1 - добавить заметку
     *     <br> 2 - посмотреть все заметки
     *     <br> 3 - редактировать заметку
     *     <br> 4 - удалить заметку
     *     <br> 5 - выйти из приложения
     * </p>
     */
    public void start() throws IOException {
        String command = notesController.menu();
        boolean closeApp = false;
        while (!closeApp) {
            switch (command) {
                case "1": {
                    command = notesController.addNote();
                    break;
                }
                case "2": {
                    command = notesController.checkNotes();
                    break;
                }
                case "3": {
                    command = notesController.editNote();
                    break;
                }
                case "4": {
                    command = notesController.deleteNote();
                    break;
                }
                case "5": {
                    notesController.close();
                    closeApp = true;
                    break;
                }
                default: {
                    command = notesController.error();
                    break;
                }
            }
        }
    }
}

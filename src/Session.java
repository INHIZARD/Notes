import controllers.NotesController;

import java.io.IOException;

public class Session {
    private final NotesController notesController;

    public Session() {
        this.notesController = new NotesController();
    }

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

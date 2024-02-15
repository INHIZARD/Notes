import sessions.Session;

import java.io.IOException;

/**
 * Класс из которого запускается приложение.
 * Дальнейшая логика реализована в классе {@code sessions.Session}.
 */
public class NotesApplication {
    public static void main(String[] args) {
        try {
            new Session().start();
        } catch (IOException exception) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}

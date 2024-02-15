import java.io.IOException;

public class NotesApplication {
    public static void main(String[] args) {
        try {
            new Session().start();
        } catch (IOException exception) {
            System.out.println("Ошибка ввода/вывода");
        }
    }
}

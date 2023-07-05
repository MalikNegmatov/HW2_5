import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String limits = "может содержать только латинские буквы, цифры, знак подчеркивания и быть не длиннее 20 символов";
        try {
            createPass("ababababababa3bababab", "abababababababababab", "abababababababababab");

        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
            System.out.println("Имя " + limits);
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println("Пароль ");
        } finally {
            System.out.println("Проверка завершена");
        }
    }

    public static void createPass(String login, String password, String confirmPassword) {
        if (!(login.length() < 21) || !Pattern.matches("(([a-zA-Z0-9_]*))", login) || login.isBlank()) {
            throw new WrongLoginException("Имя задано некорректно!");
        }
        if (!(password.length() < 21) || !Pattern.matches("(([a-zA-Z0-9_]*))", password) || password.isBlank()) {
            throw new WrongPasswordException("Пароль определен некорректно!");
        }
        if (!password.contentEquals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }
}
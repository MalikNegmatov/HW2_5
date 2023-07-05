import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Некорректные символы в логине
        createPass("orange;№(*", "01234567890123456789", "01234567890123456789");
        // Некорректные символы в пароле
        createPass("orange", "0123456%;№7823456789", "01234567890123456789");
        // Пароль длиннее 20 символов
        createPass("orange", "012345678901234567890", "012345678901234567890");
        // Пароли не совпадают
        createPass("orange", "0123456789012345678", "01234567890123456789");
    }

    public static void createPass(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPass(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            System.out.println("Используйте только латинские буквы, цифры, знак подчеркивания и не более 20 символов");
        }
        finally {
            System.out.println("Проверка завершена \n");
        }
    }

    public static void checkLogin(String login) {
        if (login.isBlank()) {
            throw new WrongLoginException("Имя не задано!");
        }
        else if (!(login.length() < 21)) {
            throw new WrongLoginException("Имя содержит более 20 символов!");
        }
        else if (!Pattern.matches("([a-zA-Z0-9_]*)", login)) {
            throw new WrongLoginException("В имени использованы некорректные символы!");
        }
    }

    public static void checkPass(String password, String confirmPassword) {
        if (password.isBlank()) {
            throw new WrongLoginException("Пароль не задан!");
        }
        else if (!(password.length() < 21)) {
            throw new WrongLoginException("Пароль содержит более 20 символов!");
        }
        else if (!Pattern.matches("([a-zA-Z0-9_]*)", password)) {
            throw new WrongLoginException("В пароле использованы некорректные символы!");
        }
        if (!password.contentEquals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }
}


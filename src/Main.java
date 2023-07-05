import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {

    }

    public static void createPass(String login, String password, String confirmPassword){
        String limits="может содержать только латинские буквы, цифры, знак подчеркивания, не длиннее 20 символов";
        if (!(login.length() < 20) || !Pattern.matches("(([a-zA-Z0-9_]*))", login) || login.isBlank()) {
            throw new WrongLoginException("Имя задано некорректно! \n Имя " + limits);
        }
        if (!(password.length() < 20) || !Pattern.matches("(([a-zA-Z0-9_]*))", password) || password.isBlank()) {
            throw new WrongPasswordException("Пароль определен некорректно! \n Пароль ");
        }
        if (!password.contentEquals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }
}

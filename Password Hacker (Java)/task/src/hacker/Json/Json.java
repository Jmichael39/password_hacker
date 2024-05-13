package hacker.Json;

public class Json {
    private String login;
    private String password;

    public Json(String user, String password) {
        this.login = user;
        this.password = password;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

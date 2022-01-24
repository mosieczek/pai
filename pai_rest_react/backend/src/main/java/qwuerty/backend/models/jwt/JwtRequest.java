package qwuerty.backend.models.jwt;


import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class JwtRequest implements Serializable {


    private static final long serialVersionUID = 6780225499655796214L;

    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawny login")
    private String username;
    @Pattern(regexp = "[A-Za-z\\d@$!%./*#?&]{8,100}",message="Podaj poprawne hasło")
    private String password;
    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawne imię")
    private String name;
    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawne nazwisko")
    private String surname;
    public JwtRequest() {}

    public JwtRequest(String username, String password, String name, String surname) {
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setSurname(surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

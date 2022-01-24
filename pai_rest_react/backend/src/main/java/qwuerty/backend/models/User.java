package qwuerty.backend.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawny login")
    @Column(name="username")
    private String username;

    @Pattern(regexp = "[A-Za-z\\d@$!%./*#?&]{8,100}",message="Podaj poprawne hasło")
    @Column(name="password")
    private String password;

    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawne imię")
    @Column(name="name")
    private String name;

    @Pattern(regexp = "[a-zA-Z]{2,30}",message="Podaj poprawne nazwisko")
    @Column(name="surname")
    private String surname;

    protected User() {}

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.setName(name);
        this.setSurname(surname);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, username, password);
    }
}

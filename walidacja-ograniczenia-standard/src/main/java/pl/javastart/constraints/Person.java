package pl.javastart.constraints;

import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.pl.PESEL;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

class Person {
    @NotNull
    @Size(min = 2)
    private String firstName;
    @NotNull
    @Size(min = 2)
    private String lastName;
    @PESEL
    private String pesel;
    @Past
    private LocalDate birthday;
    @Email
    private String email;
    @NotNull
    @Size(min = 5)
    private String password;
    @URL
    private String blogUrl;

    public Person(String firstName, String lastName, String pesel, LocalDate birthday, String email, String password, String blogUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.blogUrl = blogUrl;
    }

    //gettery, settery
}

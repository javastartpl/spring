package pl.javastart.valid;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    
    private final Set<Person> people = new HashSet<>();
    private final Validator validator;
    
    @Autowired
    public PersonService(Validator validator) {
        this.validator = validator;
    }
    
    public void addPerson(Person person) {
        Set<ConstraintViolation<Person>> errors = validator.validate(person);
        if(!errors.isEmpty()) {
            System.out.println(">Obiekt nie może być dodany, lista błędów:");
            errors.forEach(err ->
                    System.out.printf(">>> %s %s (%s)\n",
                            err.getPropertyPath(),
                            err.getMessage(),
                            err.getInvalidValue())
            );
        } else {
            people.add(person);
            System.out.println(">Obiekt został dodany");
        }
    }
    
    public Set<Person> getPeople() {
        return this.people;
    }
}

package pl.javastart.sec.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAllUsersByRoles_Name(String role);
    void deleteByEmail(String email);
}

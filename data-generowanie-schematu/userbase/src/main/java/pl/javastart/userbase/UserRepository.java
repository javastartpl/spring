package pl.javastart.userbase;

import org.springframework.data.repository.CrudRepository;

interface UserRepository extends CrudRepository<User, Long> { }

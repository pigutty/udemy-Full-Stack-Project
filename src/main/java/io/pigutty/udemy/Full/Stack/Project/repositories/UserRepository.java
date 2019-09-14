package io.pigutty.udemy.Full.Stack.Project.repositories;

import io.pigutty.udemy.Full.Stack.Project.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

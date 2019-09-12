package io.pigutty.udemy.Full.Stack.Project.repositories;

import io.pigutty.udemy.Full.Stack.Project.domain.Backlog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {
}

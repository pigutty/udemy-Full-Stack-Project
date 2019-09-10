package io.pigutty.udemy.Full.Stack.Project.repositories;

import io.pigutty.udemy.Full.Stack.Project.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Override
    Iterable<Project> findAllById(Iterable<Long> iterable);
}

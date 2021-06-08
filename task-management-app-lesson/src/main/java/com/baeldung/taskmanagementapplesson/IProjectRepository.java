package com.baeldung.taskmanagementapplesson;

import java.util.Optional;

public interface IProjectRepository {
    Optional<Project> findById(Long id);
    Project save(Project project);
}

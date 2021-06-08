package com.baeldung.taskmanagementapplesson;

import java.time.LocalDate;
import java.util.Objects;

public class Project {
    private Long id;
    private String name;
    private LocalDate dateCreated;

    public Project (Project project) {
        this(project.getId (), project.getName ( ) , project.getDateCreated ());
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public LocalDate getDateCreated () {
        return dateCreated;
    }

    public void setDateCreated ( LocalDate dateCreated ) {
        this.dateCreated = dateCreated;
    }

    public Project ( Long id , String name , LocalDate dateCreated ) {
        this.id = id;
        this.name = name;
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals ( id , project.id ) &&
                Objects.equals ( name , project.name ) &&
                Objects.equals ( dateCreated , project.dateCreated );
    }

    @Override
    public int hashCode () {
        return Objects.hash ( id , name , dateCreated );
    }
}

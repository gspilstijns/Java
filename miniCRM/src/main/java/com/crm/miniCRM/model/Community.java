package com.crm.miniCRM.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="community")
public class Community {
    //////////Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @ManyToMany(mappedBy = "member")
    private List<Person> member;
    @OneToMany(mappedBy = "community")
    private List<Event> events;
    private String description;
    private Boolean archived;

    /// Constructors
    public Community(){}

    public Community(String description) {
        this.description = description;
    }

    public Community ( String description , Boolean archived ) {
        this.description = description;
        this.archived = archived;
    }

    ///////Getters and setters

    public Boolean getArchived () {
        return archived;
    }

    public void setArchived ( Boolean archived ) {
        this.archived = archived;
    }

    public List < Person > getMember () {
        return member;
    }

    public void setMember ( List < Person > member ) {
        this.member = member;
    }
    public List < Event > getEvents () {
        return events;
    }

    public void setEvents ( List < Event > events ) {
        this.events = events;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Community{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.crm.miniCRM.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToMany(mappedBy = "member")
    private List<Person> member;

    @OneToMany(mappedBy = "community")
    private List<Event> events;

    public List < Person > getMember () {
        return member;
    }

    public void setMember ( List < Person > member ) {
        this.member = member;
    }


    private String description;

    public Community(){}

    public Community(String description) {
        this.description = description;
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

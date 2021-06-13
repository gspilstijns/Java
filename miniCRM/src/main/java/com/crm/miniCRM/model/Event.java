package com.crm.miniCRM.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate date;
    private Boolean archived;

    @ManyToOne
    @JoinColumn(name = "community_id", nullable = true)
    private Community community;

    public Community getCommunity () {
        return community;
    }

    public void setCommunity ( Community community ) {
        this.community = community;
    }


    //  private LocalTime time;


    public Event(){}
    public Event(String description, LocalDate date) {
        this.description = description;
        this.date = date;
     //   this.time = time;
    }

    public Event ( String description , LocalDate date , Community community ) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.community = community;
    }

    public Event ( String description , LocalDate date , Community community , Boolean archived ) {
        this.description = description;
        this.date = date;
        this.archived = archived;
        this.community = community;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getArchived () {
        return archived;
    }

    public void setArchived ( Boolean archived ) {
        this.archived = archived;
    }

    //    public LocalTime getTime() {
//        return time;
//    }
//
//    public void setTime(LocalTime time) {
//        this.time = time;
//    }




    @Override
    public String toString() {
        return "Event{" +
                "ID=" + id +
                ", description='" + description + '\'' +
                ", date=" + date +
                //", time=" + time +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

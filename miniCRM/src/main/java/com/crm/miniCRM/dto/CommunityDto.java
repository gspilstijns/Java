package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Event;

import java.util.List;
import java.util.Set;

public class CommunityDto {

    /////////Properties

    private Long id;
    private List< PersonDto> members;
    private List< EventDto > events;
    private String description;
    private Boolean archived;

    //// Constructors

    public CommunityDto() {
    }
    public CommunityDto(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public CommunityDto ( Long id , List < PersonDto > members , List < EventDto > events , String description ) {
        this.id = id;
        this.members = members;
        this.events = events;
        this.description = description;
    }

    public CommunityDto ( Long id , List < PersonDto > members , List < EventDto > events , String description , Boolean archived ) {
        this.id = id;
        this.members = members;
        this.events = events;
        this.description = description;
        this.archived = archived;
    }
    /////// Getters and Setters


    public Boolean getArchived () {
        return archived;
    }

    public void setArchived ( Boolean archived ) {
        this.archived = archived;
    }

    public List < EventDto > getEvents () {
        return events;
    }

    public void setEvents ( List < EventDto > events ) {
        this.events = events;
    }

    public String getDescription() {
        return description;
    }

    public List < PersonDto > getMembers () {
        return members;
    }

    public void setMembers ( List < PersonDto > members ) {
        this.members = members;
    }

    public void setDescription( String description) {
        this.description = description;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

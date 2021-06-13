package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Event;

import java.util.List;
import java.util.Set;

public class CommunityDto {

    private Long id;
    private List< PersonDto> members;
    private List< EventDto > events;

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

    private String description;

    public CommunityDto() {
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}

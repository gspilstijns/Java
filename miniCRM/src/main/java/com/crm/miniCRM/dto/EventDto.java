package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.Community;


import java.time.LocalDate;
import java.util.Date;

public class EventDto {
    private Long id;
    private String description;
    private String date;
    private CommunityDto communityDto;
    private Boolean archived;

    public EventDto () {
    }

    public EventDto ( Long id , String description , String date ) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public EventDto ( Long id , String description , String date , CommunityDto communityDto ) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.communityDto = communityDto;
    }

    public EventDto ( Long id , String description , String date , CommunityDto communityDto , Boolean archived ) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.communityDto = communityDto;
        this.archived = archived;
    }

    public Boolean getArchived () {
        return archived;
    }

    public void setArchived ( Boolean archived ) {
        this.archived = archived;
    }

    public CommunityDto getCommunityDto () {
        return communityDto;
    }

    public void setCommunityDto ( CommunityDto communityDto ) {
        this.communityDto = communityDto;
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public String getDate () {
        return date;
    }

    public void setDate ( String date ) {
        this.date = date;
    }
}

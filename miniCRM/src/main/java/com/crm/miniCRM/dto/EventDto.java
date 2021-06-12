package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.Community;

import java.time.LocalDate;

public class EventDto {
    private Long id;
    private String description;
    private LocalDate date;
    private CommunityDto communityDto;


    public EventDto () {
    }

    public EventDto ( Long id , String description , LocalDate date ) {
        this.id = id;
        this.description = description;
        this.date = date;
    }

    public EventDto ( Long id , String description , LocalDate date , CommunityDto communityDto ) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.communityDto = communityDto;
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

    public LocalDate getDate () {
        return date;
    }

    public void setDate ( LocalDate date ) {
        this.date = date;
    }
}

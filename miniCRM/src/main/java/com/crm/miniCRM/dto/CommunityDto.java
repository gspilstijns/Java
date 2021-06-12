package com.crm.miniCRM.dto;

import java.util.List;
import java.util.Set;

public class CommunityDto {

    private Long id;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
}

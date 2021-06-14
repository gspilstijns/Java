package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.persistence.MemberID;

public class MemberViewDto {
    private Long communityId;
    private String since;
    private String until;

    public MemberViewDto () {
    }

    public MemberViewDto ( Long communityId , String since , String until ) {
        this.communityId = communityId;
        this.since = since;
        this.until = until;
    }

    public Long getCommunityId () {
        return communityId;
    }

    public void setCommunityId ( Long communityId ) {
        this.communityId = communityId;
    }

    public String getSince () {
        return since;
    }

    public void setSince ( String since ) {
        this.since = since;
    }

    public String getUntil () {
        return until;
    }

    public void setUntil ( String until ) {
        this.until = until;
    }
}

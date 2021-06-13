package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.persistence.MemberID;

import java.time.LocalDate;

public class MemberDto {
    private MemberID Id;

    private String since;
    private String until;

    public MemberDto () {
    }

    public MemberDto ( MemberID id , String since , String until ) {
        Id = id;
        this.since = since;
        this.until = until;
    }

    public MemberID getId () {
        return Id;
    }

    public void setId ( MemberID id ) {
        Id = id;
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

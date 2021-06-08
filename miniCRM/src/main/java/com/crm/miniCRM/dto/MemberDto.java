package com.crm.miniCRM.dto;

import com.crm.miniCRM.model.persistence.MemberID;

import java.time.LocalDate;

public class MemberDto {
    private MemberID Id;

    private LocalDate since;
    private LocalDate until;

    public MemberDto () {
    }

    public MemberDto ( MemberID id , LocalDate since , LocalDate until ) {
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

    public LocalDate getSince () {
        return since;
    }

    public void setSince ( LocalDate since ) {
        this.since = since;
    }

    public LocalDate getUntil () {
        return until;
    }

    public void setUntil ( LocalDate until ) {
        this.until = until;
    }
}

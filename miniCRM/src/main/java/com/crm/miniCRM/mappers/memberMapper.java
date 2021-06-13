package com.crm.miniCRM.mappers;

import com.crm.miniCRM.dto.MemberDto;
import com.crm.miniCRM.model.Member;

import java.time.LocalDate;

public class memberMapper {

    public static MemberDto convertToDto( Member member){
        MemberDto dto = new MemberDto (
                member.getId (),
                member.getSince ().toString (),
                member.getUntil ().toString ()
        );
        return dto;
    }
    public static Member convertToEntity(MemberDto dto){
        int year_since = Integer.parseInt ( dto.getSince ().toString ().substring ( 0,4 ) );
        int month_since = Integer.parseInt ( dto.getSince ().toString ().substring ( 5,7 ) );
        int day_since = Integer.parseInt ( dto.getSince ().toString ().substring ( 8,10 ) );
        int year_untill = Integer.parseInt ( dto.getUntil ().toString ().substring ( 0,4 ) );
        int month_untill = Integer.parseInt ( dto.getUntil ().toString ().substring ( 5,7 ) );
        int day_untill = Integer.parseInt ( dto.getUntil ().toString ().substring ( 8,10 ) );

        Member member = new Member (
                dto.getId (),
                LocalDate.of ( year_since,month_since,day_since ) ,
                LocalDate.of ( year_untill,month_untill,day_untill )
        );

        return member;
    }
}

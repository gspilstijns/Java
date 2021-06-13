package com.crm.miniCRM.mappers;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.EventDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.model.Event;
import com.crm.miniCRM.model.Person;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class eventMapper {
    public static EventDto convertToDto( Event entity) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern ( "dd-MM-yyyy" );
        EventDto dto = new EventDto (
                entity.getId (),
                entity.getDescription (),
                entity.getDate ().toString (),
                new CommunityDto ( entity.getCommunity ().getID (),entity.getCommunity ().getDescription () ),
                entity.getArchived ()

        );
        return dto;
    }

    public static Event convertToEntity(EventDto dto) {

        int year = Integer.parseInt ( dto.getDate ().toString ().substring ( 0,4 ) );
        int month = Integer.parseInt ( dto.getDate ().toString ().substring ( 5,7 ) );
        int day = Integer.parseInt ( dto.getDate ().toString ().substring ( 8,10 ) );

        Event event = new Event (
                dto.getDescription (),
                LocalDate.of ( year,month,day ) ,
                communityMapper.convertToEntity ( dto.getCommunityDto () ),dto.getArchived ()
        );
        if (!StringUtils.isEmpty(dto.getId())) {
            event.setId (dto.getId());
        }
        return event;
    }

    public static List < EventDto > convertToDtoList ( List< Event > events ) {
        List<EventDto> list = new ArrayList <> (  );
        events.forEach ( e -> list.add ( eventMapper.convertToDto ( e ) ) );
        return list;

    }
}

package com.crm.miniCRM.mappers;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.EventDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.model.Community;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

public class communityMapper {

    public static CommunityDto convertToDto( Community entity) {
        List < PersonDto > personDtos = personMapper.convertToDtoList ( entity.getMember () );
        List < EventDto > eventDtos = eventMapper.convertToDtoList ( entity.getEvents () );
        CommunityDto dto = new CommunityDto(entity.getID(),
                personDtos , eventDtos,
                entity.getDescription(),
                entity.getArchived ());
        return dto;
    }

    public static CommunityDto convertToDto( Optional <Community> entity) {

        CommunityDto dto = new CommunityDto(entity.get ().getID(),
                personMapper.convertToDtoList ( entity.get ().getMember () ),
                eventMapper.convertToDtoList ( entity.get ().getEvents () ) ,
                entity.get ().getDescription() ,
                entity.get ().getArchived ());
        return dto;

    }

    public static Community convertToEntity(CommunityDto dto) {
        //29-06-1963

        Community community = new Community(dto.getDescription(),dto.getArchived ());
        if (!StringUtils.isEmpty(dto.getId())) {
            community.setID(dto.getId());
        }
        return community;
    }
}

package com.crm.miniCRM.mappers;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.model.Community;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

public class communityMapper {

    public static CommunityDto convertToDto( Community entity) {
        CommunityDto dto = new CommunityDto(entity.getID(), entity.getDescription());
        return dto;
    }

    public static CommunityDto convertToDto( Optional <Community> entity) {

        CommunityDto dto = new CommunityDto(entity.get().getID (), entity.get ().getDescription());
        return dto;

    }

    public static Community convertToEntity(CommunityDto dto) {
        //29-06-1963

        Community community = new Community(dto.getDescription());
        if (!StringUtils.isEmpty(dto.getId())) {
            community.setID(dto.getId());
        }
        return community;
    }
}

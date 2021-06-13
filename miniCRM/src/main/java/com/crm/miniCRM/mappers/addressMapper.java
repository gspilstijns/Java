package com.crm.miniCRM.mappers;

import com.crm.miniCRM.dto.AddressDto;
import com.crm.miniCRM.model.Address;
import org.springframework.util.StringUtils;

public class addressMapper {
    public static AddressDto convertToDto( Address entity) {
        AddressDto dto = new AddressDto (
                entity.getId (),
                entity.getStreet (),
                entity.getNumber (),
                entity.getBox (),
                entity.getZip (),
                entity.getCity (),
                entity.getCountry (),
                entity.getType (),
                entity.getArchived ()
        );
        return dto;
    }

    public static Address convertToEntity(AddressDto dto) {
        //29-06-1963

        Address address = new Address(
                dto.getStreet (),
                dto.getNumber (),
                dto.getBox (),
                dto.getZip (),
                dto.getCity (),
                dto.getCountry (),
                dto.getType (),
                dto.getArchived ()
        );
        if (!StringUtils.isEmpty(dto.getId())) {
            address.setId (dto.getId());
        }
        return address;
    }
}

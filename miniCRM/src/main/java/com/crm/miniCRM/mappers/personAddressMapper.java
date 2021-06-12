package com.crm.miniCRM.mappers;

import com.crm.miniCRM.dto.PersonAddressDto;
import com.crm.miniCRM.model.PersonAddress;

public class personAddressMapper {
    public static PersonAddress convertToEntity ( PersonAddressDto personAddressDto ) {
        PersonAddress personAddress = new PersonAddress (
                personAddressDto.getId (),
                personAddressDto.getEmail (),
                personAddressDto.getPhone (),
                personAddressDto.getMobile (),
                personAddressDto.getType (),
                addressMapper.convertToEntity ( personAddressDto.getAddressDto () )
        );
        return personAddress;
    }

    public static PersonAddressDto convertToDto ( PersonAddress p ) {
        PersonAddressDto dto = new PersonAddressDto (
                p.getId (),
                p.getEmail (),
                p.getPhone (),
                p.getMobile (),
                p.getType ()
        );
        return dto;
    }
}

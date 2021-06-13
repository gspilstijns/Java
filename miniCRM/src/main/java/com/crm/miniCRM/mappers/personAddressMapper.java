package com.crm.miniCRM.mappers;

import com.crm.miniCRM.dto.PersonAddressDto;
import com.crm.miniCRM.model.PersonAddress;

import java.util.Optional;

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
                p.getType (),
                addressMapper.convertToDto ( p.getAddress () )
        );
        return dto;
    }
    public static PersonAddressDto convertToDto ( Optional <PersonAddress> p ) {
        PersonAddressDto dto = new PersonAddressDto (
                p.get ().getId (),
                p.get ().getEmail (),
                p.get ().getPhone (),
                p.get ().getMobile (),
                p.get ().getType (),
                addressMapper.convertToDto ( p.get ().getAddress () )
        );
        return dto;
    }
}

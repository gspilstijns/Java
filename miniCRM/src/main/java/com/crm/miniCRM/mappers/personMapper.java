package com.crm.miniCRM.mappers;

import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.dto.PersonImportDto;
import com.crm.miniCRM.model.Person;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class personMapper {
    public static PersonDto convertToDto( Person entity) {
        PersonDto dto = new PersonDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getBirthDay().toString());
        return dto;
    }

    public static Person convertToEntity(PersonDto dto) {
        //29-06-1963
       /* int year = Integer.parseInt(dto.getBirthDay().toString().substring(6,10));
        int month = Integer.parseInt(dto.getBirthDay().toString().substring(3,5));
        int day = Integer.parseInt(dto.getBirthDay().toString().substring(0,2));*/


        int year = Integer.parseInt ( dto.getBirthDay ().toString ().substring ( 0,4 ) );
        int month = Integer.parseInt ( dto.getBirthDay ().toString ().substring ( 5,7 ) );
        int day = Integer.parseInt ( dto.getBirthDay ().toString ().substring ( 8,10 ) );


        Person person = new Person(dto.getFirstName(), dto.getLastName(), LocalDate.of(year, month, day));
        if (!StringUtils.isEmpty(dto.getId())) {
            person.setId(dto.getId());
        }
        return person;
    }

    public static Person convertToEntityBulkImport( PersonImportDto dto){

        String[] attributes = dto.getBirthDay ().split("/");
        int year = Integer.parseInt ( attributes[2] );
        int month = Integer.parseInt ( attributes[1] );
        int day = Integer.parseInt (attributes[0]);


        Person person = new Person(dto.getFirstName(), dto.getLastName(), LocalDate.of(year, month, day),false);

        return person;
    }

    public static List< PersonDto> convertToDtoList ( List< Person> member ) {
        List<PersonDto> list = new ArrayList <> (  );
        member.forEach ( p -> list.add ( convertToDto ( p ) ) );
        return list;

    }
}

package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.PersonAddressDto;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.PersonAddress;
import com.crm.miniCRM.model.persistence.PersonAddressRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/personaddress")
public class PersonAddressController {
    private PersonAddressRepository personAddressRepository;

    public PersonAddressController ( PersonAddressRepository personAddressRepository ) {
        this.personAddressRepository = personAddressRepository;
    }
    @GetMapping
    public String getpersonaddress( Model model){
        Iterable< PersonAddress > personAddresses = personAddressRepository.findAll ();
        List < PersonAddressDto> personAddressDtoList = new ArrayList<> (  );
        personAddresses.forEach ( p->personAddressDtoList.add ( convertToDto(p) ) );
        model.addAttribute ( "personaddress",personAddressDtoList );
        return "personaddress";
    }

    @GetMapping("/new")
    public String newpersonaddress(Model model){
        model.addAttribute ( "personaddress",new PersonAddressDto (  ) );
        return "new-personaddress";
    }

    @PostMapping
    public String addpersonaddress(PersonAddressDto personAddressDto){
        personAddressRepository.save ( convertToEntity(personAddressDto) );
        return "redirect:/personaddress";
    }

    protected PersonAddress convertToEntity ( PersonAddressDto personAddressDto ) {
    PersonAddress personAddress = new PersonAddress (
            personAddressDto.getId (),
            personAddressDto.getEmail (),
            personAddressDto.getPhone (),
            personAddressDto.getMobile (),
            personAddressDto.getType ()
    );
    return personAddress;
    }

    protected PersonAddressDto convertToDto ( PersonAddress p ) {
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

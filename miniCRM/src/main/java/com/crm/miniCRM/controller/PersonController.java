package com.crm.miniCRM.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.crm.miniCRM.dto.AddressDto;
import com.crm.miniCRM.dto.PersonAddressDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.mappers.addressMapper;
import com.crm.miniCRM.mappers.personAddressMapper;
import com.crm.miniCRM.mappers.personMapper;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.PersonAddress;
import com.crm.miniCRM.model.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonRepository personService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private PersonAddressRepository personAddressRepository;

    @GetMapping
    public String getpersons(Model model) {
        List < PersonDto > personDtos = getActivePersons ( );
        model.addAttribute("persons", personDtos);
        return "persons/persons";
    }

    @GetMapping("/persondetails/{id}")
    public String getPersonAddressById(@PathVariable long id, Model model){
        List< AddressDto > addressDtos = new ArrayList<>();
        List< PersonAddressDto > personAddressDtos = new ArrayList<>();

        Person person = personService.findById ( id );

        person.getPerson_address ().iterator ()
                .forEachRemaining ( a -> {
                    addressDtos.add ( addressMapper.convertToDto ( a ) );
                    Optional < PersonAddress > personAddress= personAddressRepository.findById ( getPersonAddressID (a.getId (),person.getId ()));
                    if (personAddress.isPresent ()){personAddressDtos.add ( personAddressMapper.convertToDto ( personAddress) );}
                });

        model.addAttribute("addresses", addressDtos);
        model.addAttribute("person", personMapper.convertToDto ( person));
        model.addAttribute("personAddress", personAddressDtos);

        //todo: make frontend
        //todo: add button to person frontend for link
        //todo: make edit window
        return "persons/person-detail";
    }


    @GetMapping("/new")
    public String newperson(Model model) {
        model.addAttribute("person", new PersonDto());
        return "persons/new-person";
    }

    @PostMapping
    public String addperson(PersonDto person) {
        personService.save(personMapper.convertToEntity (person));
        return "redirect:/persons";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm( @PathVariable("id") long id, Model model ){
        Person person = personService.findById ( id );
        model.addAttribute ( "person", personMapper.convertToDto ( person ) );
        return "persons/update-person";

    }
    @PostMapping("/edit/{id}")
    public String updateUser( @PathVariable("id") long id, PersonDto personDto,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            personDto.setId(id);
            return "persons/update-person";
        }

        personService.save( personMapper.convertToEntity ( personDto ));
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser( @PathVariable("id") long id, Model model ){
        Person person = personService.findById ( id );
        person.setArchived ( true );
        person.getMember ().removeAll ( person.getMember () );
        personService.save ( person );
        //model.addAttribute ( "person", personMapper.convertToDto ( person ) );
        return "redirect:/persons";

    }


    ////////////////////////////
    /// Extracted methods below
    ////////////////////////////
    private PersonAddressID getPersonAddressID( long idAddress, long idPerson) {
        PersonAddressID paID = new PersonAddressID();
        paID.setAddress_ID(idAddress);
        paID.setPerson_ID(idPerson);
        return paID;
    }

    private List < PersonDto > getActivePersons () {
        Iterable<Person> persons = personService.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        persons.forEach(p ->{
            if (!p.getArchived ()){
                personDtos.add(personMapper.convertToDto (p));
            }
        } );
        return personDtos;
    }


}

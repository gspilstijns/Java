package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.AddressDto;
import com.crm.miniCRM.dto.PersonAddressDto;
import com.crm.miniCRM.mappers.addressMapper;
import com.crm.miniCRM.mappers.personAddressMapper;
import com.crm.miniCRM.mappers.personMapper;
import com.crm.miniCRM.model.Address;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.PersonAddress;
import com.crm.miniCRM.model.persistence.AddressRepository;
import com.crm.miniCRM.model.persistence.PersonAddressID;
import com.crm.miniCRM.model.persistence.PersonAddressRepository;
import com.crm.miniCRM.model.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/personaddress")
public class PersonAddressController {
    private PersonAddressRepository personAddressRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    public PersonAddressController ( PersonAddressRepository personAddressRepository ) {
        this.personAddressRepository = personAddressRepository;
    }

    @GetMapping("/person/{id}")
    public String getPersonAddressById(@PathVariable long id, Model model){
        List< AddressDto > addressDtos = new ArrayList<>();
        List<PersonAddressDto> personAddressDtos = new ArrayList<>();

        Person person = personRepository.findById ( id );

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
        return "personAddress/personaddress";
    }

    private PersonAddressID getPersonAddressID(long idAddress, long idPerson) {
        PersonAddressID paID = new PersonAddressID();
        paID.setAddress_ID(idAddress);
        paID.setPerson_ID(idPerson);
        return paID;
    }

    @GetMapping
    public String getpersonaddress( Model model){
        Iterable< PersonAddress > personAddresses = personAddressRepository.findAll ();

        List < PersonAddressDto> personAddressDtoList = new ArrayList<> (  );
        personAddresses.forEach ( p->personAddressDtoList.add ( personAddressMapper.convertToDto (p) ) );

        List<PersonAddressDto> list = new ArrayList <> (  );
        personAddressDtoList.stream ().filter ( x -> x.getId ().getPerson_ID () ==1 ).forEach ( p-> list.add(p) );

        model.addAttribute ( "personaddress",list );
        return "personAddress/personaddress";
    }

    @GetMapping("/new")
    public String newpersonaddress(Model model){
        Iterable<Address> addresses =  addressRepository.findAll ();
        List <AddressDto> addressDtos = new ArrayList <> (  );
        addresses.forEach ( a-> addressDtos.add ( addressMapper.convertToDto ( a ) ) );

        model.addAttribute ( "addresses", addressDtos );
        model.addAttribute ( "personaddress",new PersonAddressDto (  ) );
        return "personAddress/new-personaddress";
    }

    @GetMapping("/new/{personid}")
    public String newpersonaddress(@PathVariable("personid") Long personid, Model model){
        Iterable<Address> addresses =  addressRepository.findAll ();
        List <AddressDto> addressDtos = new ArrayList <> (  );
        addresses.forEach ( a-> addressDtos.add ( addressMapper.convertToDto ( a ) ) );

        PersonAddressDto personAddressDto = new PersonAddressDto (  );
        PersonAddressID personAddressID = new PersonAddressID ( personid, Integer.toUnsignedLong ( 1 ) );
        personAddressDto.setId ( personAddressID );

        model.addAttribute ( "addresses", addressDtos );
        model.addAttribute ( "personaddress", personAddressDto);
        model.addAttribute ( "personid",personid );
        return "personAddress/new-personaddress";
    }

    @PostMapping("/new/{personid}")
    public String addpersonaddress(@PathVariable("personid") Long personid, PersonAddressDto personAddressDto){

        Optional < Address > address = addressRepository.findById ( personAddressDto.getAddressDto ().getId () );
        if (address.isPresent ()){
            personAddressDto.setAddressDto ( addressMapper.convertToDto ( address.get () ) );
            personAddressDto.setId ( new PersonAddressID ( personid,address.get ().getId ()) );
        }

        personAddressRepository.save ( personAddressMapper.convertToEntity (personAddressDto) );
        return "redirect:/persons";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm( @PathVariable("id") PersonAddressID id, Model model ){
        Optional < PersonAddress > personAddress = personAddressRepository.findById ( id );
        model.addAttribute ( "event", personAddressMapper.convertToDto ( personAddress.get () ) );
        return "personAddress/update-event";

    }
    @PostMapping("/edit/{id}")
    public String updateEvent( @PathVariable("id") PersonAddressID id, PersonAddressDto personAddressDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            personAddressDto.setId(id);
            return "personAddress/update-person";
        }

        personAddressRepository.save(personAddressMapper.convertToEntity ( personAddressDto ));
        return "redirect:/personaddress";
    }



    /*protected PersonAddress convertToEntity ( PersonAddressDto personAddressDto ) {
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
    }*/

}

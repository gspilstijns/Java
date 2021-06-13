package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.AddressDto;
import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.mappers.addressMapper;
import com.crm.miniCRM.mappers.communityMapper;
import com.crm.miniCRM.model.Address;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Event;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.persistence.AddressRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/address")
public class AddressController {
    private AddressRepository addressRepository;

    public AddressController ( AddressRepository addressRepository ) {
        this.addressRepository = addressRepository;
    }

    @GetMapping
    public String getaddress( Model model) {
       /* Iterable< Address > addresses = addressRepository.findAll();
        List < AddressDto > addressDtos = new ArrayList <> ();
        addresses.forEach(p -> addressDtos.add(addressMapper.convertToDto(p)));*/
        model.addAttribute("addresses", getActiveAddresses());
        return "addresses/addresses";
    }

    @GetMapping("/new")
    public String newadress(Model model) {
        model.addAttribute("address", new AddressDto ());
        return "addresses/new-address";
    }

    @PostMapping
    public String addaddress(AddressDto addressDto) {
        addressRepository.save(addressMapper.convertToEntity(addressDto));

        return "redirect:/address";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm( @PathVariable("id") long id, Model model ){
        Address address = addressRepository.findById ( id );
        model.addAttribute ( "address", addressMapper.convertToDto ( address ) );
        return "addresses/update-address";

    }
    @PostMapping("/edit/{id}")
    public String updateAddress( @PathVariable("id") long id, AddressDto addressDto,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            addressDto.setId(id);
            return "addresses/update-address";
        }

        addressRepository.save( addressMapper.convertToEntity (  addressDto ));
        return "redirect:/address";
    }

    @GetMapping("/delete/{id}")
    public String deleteAddress( @PathVariable("id") long id, Model model ){
        Address address = addressRepository.findById ( id );
        address.setArchived ( true );
        addressRepository.save ( address );
        return "redirect:/address";
    }

    private List < AddressDto > getActiveAddresses () {
        Iterable< Address > addresses = addressRepository.findAll();
        List<AddressDto> addressDtos = new ArrayList<>();

        //only take the active ones
        addresses.forEach(a ->{
            if (!a.getArchived ()){

                addressDtos.add( addressMapper.convertToDto (a));

            }
        } );
        return addressDtos;
    }
    private List < AddressDto > getArchivedAddresses () {
        Iterable< Address > addresses = addressRepository.findAll();
        List<AddressDto> addressDtos = new ArrayList<>();

        //only take the archived ones
        addresses.forEach(a ->{
            if (!a.getArchived ()){

                addressDtos.add( addressMapper.convertToDto (a));

            }
        } );
        return addressDtos;
    }

}

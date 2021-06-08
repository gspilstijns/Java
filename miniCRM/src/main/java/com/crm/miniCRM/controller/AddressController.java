package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.AddressDto;
import com.crm.miniCRM.model.Address;
import com.crm.miniCRM.model.persistence.AddressRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
        Iterable< Address > addresses = addressRepository.findAll();
        List < AddressDto > addressDtos = new ArrayList <> ();
        addresses.forEach(p -> addressDtos.add(convertToDto(p)));
        model.addAttribute("addresses", addressDtos);
        return "addresses/addresses";
    }

    @GetMapping("/new")
    public String newadress(Model model) {
        model.addAttribute("address", new AddressDto ());
        return "new-address";
    }

    @PostMapping
    public String addaddress(AddressDto addressDto) {
        addressRepository.save(convertToEntity(addressDto));

        return "redirect:/addresses";
    }
    protected AddressDto convertToDto(Address entity) {
        AddressDto dto = new AddressDto (
                entity.getId (),
                entity.getStreet (),
                entity.getNumber (),
                entity.getBox (),
                entity.getZip (),
                entity.getCity (),
                entity.getCountry (),
                entity.getType ()
        );
        return dto;
    }

    protected Address convertToEntity(AddressDto dto) {
        //29-06-1963

        Address address = new Address(
                dto.getStreet (),
                dto.getNumber (),
                dto.getBox (),
                dto.getZip (),
                dto.getCity (),
                dto.getCountry (),
                dto.getType ()
        );
        if (!StringUtils.isEmpty(dto.getId())) {
            address.setId (dto.getId());
        }
        return address;
    }

}

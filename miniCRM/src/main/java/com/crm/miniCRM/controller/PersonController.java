package com.crm.miniCRM.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.mappers.communityMapper;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.persistence.CommunityRepository;
import com.crm.miniCRM.model.persistence.MemberRepository;
import com.crm.miniCRM.model.persistence.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/persons")
public class PersonController {

    private PersonRepository personService;
    private MemberRepository memberRepository;
    private CommunityRepository communityRepository;

    public PersonController ( PersonRepository personService , MemberRepository memberRepository , CommunityRepository communityRepository ) {
        this.personService = personService;
        this.memberRepository = memberRepository;
        this.communityRepository = communityRepository;
    }

    @GetMapping
    public String getpersons(Model model) {
        Iterable<Person> persons = personService.findAll();
        List<PersonDto> personDtos = new ArrayList<>();
        persons.forEach(p -> personDtos.add(convertToDto(p)));
        model.addAttribute("persons", personDtos);
        return "persons/persons";
    }

    @GetMapping("/new")
    public String newperson(Model model) {
        model.addAttribute("person", new PersonDto());
        return "persons/new-person";
    }

    @PostMapping
    public String addperson(PersonDto person) {
        personService.save(convertToEntity(person));
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm( @PathVariable("id") long id, Model model ){
        Person person = personService.findById ( id );
        model.addAttribute ( "person", convertToDto ( person ) );
        return "persons/update-person";

    }
    @PostMapping("/edit/{id}")
    public String updateUser( @PathVariable("id") long id, PersonDto personDto,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            personDto.setId(id);
            return "persons/update-person";
        }

        personService.save(convertToEntity ( personDto ));
        return "redirect:/persons";
    }


    //

    protected PersonDto convertToDto(Person entity) {
        PersonDto dto = new PersonDto(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getBirthDay().toString());
         return dto;
    }

    protected Person convertToEntity(PersonDto dto) {
        //29-06-1963
        int year = Integer.parseInt(dto.getBirthDay().toString().substring(6,10));
        int month = Integer.parseInt(dto.getBirthDay().toString().substring(3,5));
        int day = Integer.parseInt(dto.getBirthDay().toString().substring(0,2));
        Person person = new Person(dto.getFirstName(), dto.getLastName(), LocalDate.of(year, month, day));
        if (!StringUtils.isEmpty(dto.getId())) {
            person.setId(dto.getId());
        }
        return person;
    }



}

package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.*;
import com.crm.miniCRM.mappers.communityMapper;
import com.crm.miniCRM.mappers.memberMapper;
import com.crm.miniCRM.mappers.personMapper;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Member;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.persistence.CommunityRepository;
import com.crm.miniCRM.model.persistence.MemberID;
import com.crm.miniCRM.model.persistence.MemberRepository;
import com.crm.miniCRM.model.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/members")
public class MemberController {
    private MemberRepository memberRepository;
    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private PersonRepository personRepository;

    public MemberController ( MemberRepository memberRepository ) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public String getmember( Model model){
        Iterable< Member > members = memberRepository.findAll ();
        List<MemberDto> memberDtos = new ArrayList <> (  );
        members.forEach ( m-> memberDtos.add ( memberMapper.convertToDto (m) ) );
        model.addAttribute ( "members", memberDtos );
        return  "members";
    }
    @GetMapping("/new")
    public String newmember(Model model) {
        model.addAttribute ( "member", new MemberDto (  ) );
        model.addAttribute ( "persons", getPersonDtos () );
        model.addAttribute ( "communities", getCommunityDtos() );
        return "members/new-member";
    }

    /*@GetMapping("/addpersontocommunity/{id}")
    public String showUpdateForm( @PathVariable("id") long id, Model model ){

        MemberDto dto = new MemberDto (  );
        MemberID memberID = new MemberID ( );
        memberID.setPerson_ID ( id );
        dto.setId ( memberID );
        model.addAttribute ( "member", new MemberDto (  ) );
        model.addAttribute ( "persons", getPersonDtos () );
        model.addAttribute ( "communities", getCommunityDtos() );
        return "members/add-person-to-community";

    }*/

    @PostMapping
    public String addmember(MemberDto memberDto){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy-MM-dd" );

        memberDto.setSince ( LocalDate.now ().format ( formatter ) );
        memberRepository.save ( memberMapper.convertToEntity ( memberDto) );
        // todo: return page is not existing
        return "redirect:/members";
    }

    private List < CommunityDto > getCommunityDtos () {
        Iterable < Community > communityList = communityRepository.findAll ();
        List <CommunityDto> communityDtos = new ArrayList <> (  );
        communityList.forEach ( c-> communityDtos.add ( communityMapper.convertToDto ( c ) ) );
        return communityDtos;
    }

    private List < PersonDto > getPersonDtos () {
        Iterable < Person > personList = personRepository.findAll ();
        List <PersonDto> personDtos = new ArrayList <> (  );
        personList.forEach ( p-> personDtos.add ( personMapper.convertToDto ( p ) ) );
        return personDtos;
    }

    /*@PostMapping("/edit/{id}")
    public String updateUser( @PathVariable("id") long id, MemberDto memberDto,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            memberDto.setId(id);
            return "persons/update-person";
        }

        memberRepository.save(convertToEntity ( memberDto ));
        return "redirect:/persons";
    }*/


}

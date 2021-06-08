package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.AddressDto;
import com.crm.miniCRM.dto.EventDto;
import com.crm.miniCRM.dto.MemberDto;
import com.crm.miniCRM.model.Member;
import com.crm.miniCRM.model.persistence.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/members")
public class MemberController {
    private MemberRepository memberRepository;

    public MemberController ( MemberRepository memberRepository ) {
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public String getmember( Model model){
        Iterable< Member > members = memberRepository.findAll ();
        List<MemberDto> memberDtos = new ArrayList <> (  );
        members.forEach ( m-> memberDtos.add ( convertToDto(m) ) );
        model.addAttribute ( "members", memberDtos );
        return  "members";
    }
    @GetMapping("/new")
    public String newmember(Model model) {
        model.addAttribute("member", new MemberDto ());
        return "new-member";
    }
    @PostMapping
    public String addmember(MemberDto memberDto){
        memberRepository.save ( convertToEntity(memberDto) );
        return "redirect:/members";
    }
    protected MemberDto convertToDto(Member member){
        MemberDto dto = new MemberDto (
          member.getId (),
          member.getSince (),
          member.getUntil ()
        );
        return dto;
    }
    protected Member convertToEntity(MemberDto dto){
        Member member = new Member (
                dto.getId (),
                dto.getSince (),
                dto.getUntil ()
        );

        return member;
    }
}

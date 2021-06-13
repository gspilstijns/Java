package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.EventDto;
import com.crm.miniCRM.mappers.communityMapper;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Event;
import com.crm.miniCRM.model.persistence.CommunityRepository;
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
@RequestMapping(value = "/communities")
public class CommunityController {

    private CommunityRepository communityService;

    public CommunityController(CommunityRepository communityService) {
        this.communityService = communityService;
    }

    @GetMapping
    public String getcommunities(Model model) {
        Iterable<Community> communities = communityService.findAll();
        List<CommunityDto> CommunityDtos = new ArrayList<>();
        communities.forEach(p -> CommunityDtos.add(communityMapper.convertToDto(p)));
        model.addAttribute("communities", CommunityDtos);
        return "communities/communities";
    }

    @GetMapping("/new")
    public String newcommunity(Model model) {
        model.addAttribute("community", new CommunityDto());
        return "communities/new-community";
    }

    @PostMapping
    public String addcommunity(CommunityDto community) {
        communityService.save(communityMapper.convertToEntity(community));

        return "redirect:communities/communities";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm( @PathVariable("id") long id, Model model ){
        Community community = communityService.findById ( id );
        CommunityDto dto = communityMapper.convertToDto ( community );

        model.addAttribute ( "community", dto );

        return "communities/update-community";

    }
    @PostMapping("/edit/{id}")
    public String updateCommunity( @PathVariable("id") long id, CommunityDto communityDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            communityDto.setId(id);
            return "communities/update-community";
        }

        communityService.save(communityMapper.convertToEntity ( communityDto ));
        return "redirect:communities/communities";
    }
    //




}

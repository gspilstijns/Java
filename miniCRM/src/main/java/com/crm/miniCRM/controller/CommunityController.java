package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.EventDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.mappers.communityMapper;
import com.crm.miniCRM.mappers.eventMapper;
import com.crm.miniCRM.mappers.personMapper;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Event;
import com.crm.miniCRM.model.Person;
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
import java.util.Optional;


@Controller
@RequestMapping(value = "/communities")
public class CommunityController {

    private CommunityRepository communityService;

    public CommunityController(CommunityRepository communityService) {
        this.communityService = communityService;
    }

    @GetMapping
    public String getcommunities(Model model) {
        List<CommunityDto> CommunityDtos = getActiveCommunities ();
        model.addAttribute("communities", CommunityDtos);
        return "communities/communities";
    }
    @GetMapping("/archive")
    public String getCommunitiesArchive(Model model) {
        List<CommunityDto> CommunityDtos = getArchivedCommunities ();
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
        List <EventDto> eventDtos = new ArrayList <> (  );
        dto.getEvents ().stream( ).filter ( e-> e.getArchived () == false ).forEach ( event -> eventDtos.add ( event));

        model.addAttribute ( "community", dto );
        model.addAttribute ( "events", eventDtos );
        return "communities/update-community";

    }
    @PostMapping("/edit/{id}")
    public String updateCommunity( @PathVariable("id") long id, CommunityDto communityDto,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            communityDto.setId(id);
            return "communities/update-community";
        }
        Optional < Community > community = communityService.findById ( communityDto.getId () );
        community.get ().setDescription ( communityDto.getDescription () );

        communityService.save(community.get ());
        return "redirect:/communities";
    }


    @GetMapping("/delete/{id}")
    public String deleteCommunity( @PathVariable("id") long id, Model model ){
        Community community = communityService.findById ( id );
        community.setArchived ( true );

        community.getEvents ().forEach ( e -> e.setArchived ( true ) );
        //person.getMember ().removeAll ( person.getMember () );
        communityService.save ( community );
        //personService.save ( person );
        //model.addAttribute ( "person", personMapper.convertToDto ( person ) );
        return "redirect:/communities";
    }

    private List < CommunityDto > getActiveCommunities () {
        Iterable<Community> communities = communityService.findAll();
        List<CommunityDto> communityDtos = new ArrayList<>();
        List<Event> events = new ArrayList <> (  );

        // only take the active communities and check to only take the active events
        communities.forEach(p ->{
            if (!p.getArchived ()){
                p.getEvents ().forEach ( e-> {
                    if (!e.getArchived ()){
                    events.add ( e );
                    }
                } );
                p.setEvents ( events );
                communityDtos.add( communityMapper.convertToDto (p));
                events.clear ();
            }
        } );
        return communityDtos;
    }
    private List < CommunityDto > getArchivedCommunities () {
        Iterable<Community> communities = communityService.findAll();
        List<CommunityDto> communityDtos = new ArrayList<>();
        communities.forEach(p ->{
            if (p.getArchived ()){
                communityDtos.add( communityMapper.convertToDto (p));
            }
        } );
        return communityDtos;
    }

}

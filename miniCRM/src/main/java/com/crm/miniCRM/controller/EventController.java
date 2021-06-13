package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.CommunityDto;
import com.crm.miniCRM.dto.EventDto;
import com.crm.miniCRM.dto.PersonDto;
import com.crm.miniCRM.mappers.communityMapper;
import com.crm.miniCRM.mappers.eventMapper;
import com.crm.miniCRM.model.Community;
import com.crm.miniCRM.model.Event;
import com.crm.miniCRM.model.Person;
import com.crm.miniCRM.model.persistence.CommunityRepository;
import com.crm.miniCRM.model.persistence.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/events")
public class EventController {
    private EventRepository eventRepository;

    @Autowired
    private CommunityRepository communityRepository;

    public EventController ( EventRepository eventRepository  ) {
        this.eventRepository = eventRepository;

    }
    @GetMapping
    public String getevent( Model model){
        Iterable< Event > events = eventRepository.findAll ();
        List < EventDto > eventDtoList = new ArrayList<> (  );
        events.forEach ( e -> eventDtoList.add ( eventMapper.convertToDto (e) ) );
        model.addAttribute ( "events",eventDtoList );
        return "events/events";
    }

    @GetMapping("/new")
    public String newevent(Model model){
        model.addAttribute ( "event",new EventDto (  ) );
        model.addAttribute ( "communityList", getCommunityDtos() );
        return "events/new-event";
    }


    private List < CommunityDto > getCommunityDtos () {
        Iterable < Community > communityList = communityRepository.findAll ();
        List <CommunityDto> communityDtos = new ArrayList <> (  );
        communityList.forEach ( c-> communityDtos.add ( communityMapper.convertToDto ( c ) ) );
        return communityDtos;
    }

    @PostMapping
    public String addevent(EventDto eventDto){
        //retreive all info from Community to update the description also
        Optional < Community > community = communityRepository.findById ( eventDto.getCommunityDto ( ).getId ( ) );
        if (community.isPresent ()){
            eventDto.setCommunityDto ( communityMapper.convertToDto ( community ) );
        }
        //save the eventDto as entity
        eventRepository.save ( eventMapper.convertToEntity (eventDto));
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm( @PathVariable("id") long id, Model model ){
        Event event = eventRepository.findById ( id );
        model.addAttribute ( "event", eventMapper.convertToDto ( event ) );
        model.addAttribute ( "communityList", getCommunityDtos() );
        return "events/update-event";

    }
    @PostMapping("/edit/{id}")
    public String updateEvent( @PathVariable("id") long id, EventDto eventDto,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            eventDto.setId(id);
            return "persons/update-person";
        }

        eventRepository.save(eventMapper.convertToEntity ( eventDto ));
        return "redirect:/events";
    }



}

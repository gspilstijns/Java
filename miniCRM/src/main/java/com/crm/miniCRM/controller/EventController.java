package com.crm.miniCRM.controller;

import com.crm.miniCRM.dto.EventDto;
import com.crm.miniCRM.model.Event;
import com.crm.miniCRM.model.persistence.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/events")
public class EventController {
    private EventRepository eventRepository;

    public EventController ( EventRepository eventRepository ) {
        this.eventRepository = eventRepository;
    }
    @GetMapping
    public String getevent( Model model){
        Iterable< Event > events = eventRepository.findAll ();
        List < EventDto > eventDtoList = new ArrayList<> (  );
        events.forEach ( e -> eventDtoList.add ( convertToDto(e) ) );
        model.addAttribute ( "events",eventDtoList );
        return "events/events";
    }

    @GetMapping("/new")
    public String newevent(Model model){
        model.addAttribute ( "event",new EventDto (  ) );
        return "new-event";
    }
    @PostMapping
    public String addevent(EventDto eventDto){
        eventRepository.save ( convertToEntity(eventDto) );
        return "redirect:/events";
    }

    protected EventDto convertToDto( Event entity) {
        EventDto dto = new EventDto (
                entity.getId (),
                entity.getDescription (),
                entity.getDate ()
        );
        return dto;
    }

    protected Event convertToEntity(EventDto dto) {

        Event event = new Event (
                dto.getDescription (),
                dto.getDate ()
        );
        if (!StringUtils.isEmpty(dto.getId())) {
            event.setId (dto.getId());
        }
        return event;
    }
}

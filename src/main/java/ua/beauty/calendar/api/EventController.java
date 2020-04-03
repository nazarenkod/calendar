package ua.beauty.calendar.api;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.beauty.calendar.domain.EditEventRequest;
import ua.beauty.calendar.domain.Event;
import ua.beauty.calendar.domain.EventRequest;
import ua.beauty.calendar.domain.Master;
import ua.beauty.calendar.model.CreateEventResponse;
import ua.beauty.calendar.model.EditEventResponse;
import ua.beauty.calendar.model.EventResponse;
import ua.beauty.calendar.model.RemoveEventResponse;
import ua.beauty.calendar.service.EventService;
import ua.beauty.calendar.service.MasterService;

import javax.validation.Valid;
import java.util.Optional;


//это есть адаптер

@RestController
@AllArgsConstructor
public class EventController {

    private final EventService eventService;
    private final MasterService masterService;


    @RequestMapping(method = RequestMethod.GET,path = "/event",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    EventResponse findAllEvents() {

        return new EventResponse("success", eventService.findAll());

    }




    @PostMapping(path = "/addEvent",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    CreateEventResponse addEvent(@RequestBody @Valid EventRequest request) {
        Event event = new Event();
        event.setClientName(request.getClientName());
        event.setPhoneNumber(request.getPhoneNumber());
        event.setInstagram(request.getInstagram());
        event.setPrice(request.getPrice());
        event.setTime(request.getTime());
        event.setDate(request.getDate());
        event.setDuration(request.getDuration());
        Optional<Master> master = masterService.findById(request.getMasterId());
        event.setMaster(master.get());
        Long id = eventService.addEvent(event);
        return new CreateEventResponse("success", "created", id);
    }

    @PostMapping(path = "/editEvent", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    EditEventResponse editEvent(@RequestBody @Valid EditEventRequest request) {
        Event event = new Event();
        event.setId(request.getId().longValue());
        event.setClientName(request.getClientName());
        event.setPhoneNumber(request.getPhoneNumber());
        event.setInstagram(request.getInstagram());
        event.setPrice(request.getPrice());
        event.setDate(request.getDate());
        event.setTime(request.getTime());
        event.setDuration(request.getDuration());
        Optional<Master> master = masterService.findById(request.getMasterId());
        event.setMaster(master.get());
        Long id = eventService.addEvent(event);
        return new EditEventResponse("success", "edited", id);
    }

    @GetMapping("/event/remove/{id}")
    public RemoveEventResponse removeEvent(@PathVariable(value = "id") String eventId) {
        System.out.println("=================remove======================");
        Long id = eventService.removeEvent(new Long(eventId));
        return new RemoveEventResponse("success", "removed", id);
    }






}

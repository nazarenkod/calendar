package ua.beauty.calendar.api;







import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.beauty.calendar.domain.CalendarEvent;
import ua.beauty.calendar.domain.dto.EventRequest;
import ua.beauty.calendar.model.BaseEventResponse;
import ua.beauty.calendar.service.CalendarService;

import javax.validation.Valid;


//это есть адаптер

@RestController
@AllArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;


    @RequestMapping(method = RequestMethod.GET,path = "/events",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    BaseEventResponse findAllEvents(){
        return new BaseEventResponse("success",calendarService.getAllEvents());
    }



    @PostMapping(path = "/events",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    CalendarEvent addEvent(@RequestBody @Valid EventRequest request){
        return calendarService.addEvents(request);

    }



}

package ua.beauty.calendar.api;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.beauty.calendar.domain.Event;
import ua.beauty.calendar.domain.EventRequest;
import ua.beauty.calendar.domain.Master;
import ua.beauty.calendar.exception.ResourceNotFoundException;
import ua.beauty.calendar.service.EventService;
import ua.beauty.calendar.service.MasterService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


//это есть адаптер

@RestController
@AllArgsConstructor
public class EventController {

    private final EventService eventService;
    private final MasterService masterService;


    @RequestMapping(method = RequestMethod.GET,path = "/event",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    List<Event> findAllEvents(){
        return eventService.findAll();
    }




    @PostMapping(path = "/addEvent",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    long addEvent(@RequestBody @Valid EventRequest request){
        Event event = new Event();
        System.out.println("req: " + request.toString());
        event.setClientName(request.getClientName());
        event.setPhoneNumber(request.getPhoneNumber());
        event.setInstagram(request.getInstagram());
        event.setPrice(request.getPrice());





        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(request.getDate(),df);
        LocalTime localTime = LocalTime.parse(request.getTime());
        LocalTime localDuration = LocalTime.parse(request.getDuration());
        Integer hour = localDuration.getHour();
        Integer min = localDuration.getMinute();

        LocalDateTime start = LocalDateTime.of(localDate,localTime);
        LocalDateTime end = start.plusHours(hour).plusMinutes(min);



        event.setStartDateTime(start.toString());
        event.setEndDateTime(end.toString());

        System.out.println("client name: "+ request.getClientName());
        System.out.println("phone: "+ request.getPhoneNumber());
        System.out.println("insta: "+ request.getInstagram());
        System.out.println("price: "+ request.getPrice());
        System.out.println("date: "+ request.getDate());
        System.out.println("time: "+ request.getTime());
        System.out.println("duration: "+ request.getDuration());
        System.out.println("master: " + request.getMasterId());
        Optional<Master> master = masterService.findById(request.getMasterId());
        event.setMaster(master.get());
        eventService.addEvent(event);
        return eventService.addEvent(event);

    }

    @GetMapping("/event/remove/{id}")
    public ResponseEntity removeEvent(@PathVariable(value = "id") Long eventId)
            throws ResourceNotFoundException {
        eventService.removeEvent(eventId);
        return ResponseEntity.ok("success");
    }






}

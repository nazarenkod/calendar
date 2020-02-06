package ua.beauty.calendar.api;







import com.google.api.client.util.DateTime;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.beauty.calendar.domain.CalendarEvent;
import ua.beauty.calendar.domain.dto.EventRequest;
import ua.beauty.calendar.model.BaseEventResponse;
import ua.beauty.calendar.service.CalendarService;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


//это есть адаптер

@RestController
@AllArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;


    @RequestMapping(method = RequestMethod.GET,path = "/events",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    BaseEventResponse findAllEvents(){
        return new BaseEventResponse("success",calendarService.getAllEvents());
    }



    @PostMapping(path = "/addEvent",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    String addEvent(@RequestBody @Valid EventRequest request){

        System.out.println("date "+request.getDate());
        System.out.println("time "+request.getTime());
        System.out.println("duration "+request.getDuration());



        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(request.getDate(),df);
        LocalTime localTime = LocalTime.parse(request.getTime());
        LocalTime localDuration = LocalTime.parse(request.getDuration());

        System.out.println("localDate "+localDate);
        System.out.println("localTime "+localTime);
        System.out.println("localDuration "+localDuration);







        return "true";

    }



}

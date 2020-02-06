package ua.beauty.calendar.api;







import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.beauty.calendar.domain.CalendarEvent;
import ua.beauty.calendar.domain.Master;
import ua.beauty.calendar.domain.dto.EventRequest;
import ua.beauty.calendar.model.BaseEventResponse;
import ua.beauty.calendar.model.BaseMasterResponse;
import ua.beauty.calendar.service.CalendarService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


//это есть адаптер

@RestController
@AllArgsConstructor
public class MasterController {
    private final CalendarService calendarService;


//    @RequestMapping(method = RequestMethod.GET,path = "/master",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
//    BaseMasterResponse findAllEvents(){
//        Master polina = new Master(1,"Полина");
//        Master diana = new Master(2,"Диана");
//        List<Master> masters = new ArrayList();
//        masters.add(polina);
//        masters.add(diana);
//
//        return new BaseMasterResponse("success",masters);
//    }
//
@RequestMapping(method = RequestMethod.GET,path = "/master",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
List<Master> findAllEvents(){
    Master polina = new Master(1,"Полина");
    Master diana = new Master(2,"Диана");
    List<Master> masters = new ArrayList();
    masters.add(polina);
    masters.add(diana);

    return masters;
}






}

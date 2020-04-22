package ua.beauty.calendar.api;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.beauty.calendar.domain.EditEventRequest;
import ua.beauty.calendar.domain.Event;
import ua.beauty.calendar.domain.EventRequest;
import ua.beauty.calendar.model.CreateEventResponse;
import ua.beauty.calendar.model.EditEventResponse;
import ua.beauty.calendar.model.EventResponse;
import ua.beauty.calendar.model.RemoveEventResponse;
import ua.beauty.calendar.service.EventService;
import ua.beauty.calendar.service.MasterService;
import ua.beauty.calendar.service.ProcedureService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//это есть адаптер

@RestController
@AllArgsConstructor
public class EventController {


    private final EventService eventService;
    private final MasterService masterService;
    private final ProcedureService procedureService;


    @RequestMapping(method = RequestMethod.GET,path = "/event",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    EventResponse findAllEvents() {

        return new EventResponse("success", eventService.findAll());

    }

    public static boolean isEventsEquals(Optional<Event> eventFromDb, EditEventRequest editedEvent) {
        boolean result = false;
        if (editedEvent.getFreeDay()) {
            if (
                    eventFromDb.get().getId().equals(editedEvent.getId()) &&
                            eventFromDb.get().getFreeDay().equals(editedEvent.getFreeDay()) &&
                            eventFromDb.get().getDate().equals(editedEvent.getDate()) &&
                            eventFromDb.get().getMaster().getId().equals(editedEvent.getMaster().getId())
            ) {
                result = true;
            }
        } else {
            if (
                    eventFromDb.get().getId().equals(editedEvent.getId())
                            &&
                            eventFromDb.get().getClientName().equals(editedEvent.getClientName())
                            &&
                            eventFromDb.get().getInstagram().equals(editedEvent.getInstagram()) &&
                            eventFromDb.get().getPhoneNumber().equals(editedEvent.getPhoneNumber()) &&
                            eventFromDb.get().getPrice().equals(editedEvent.getPrice())
                            &&
                            eventFromDb.get().getDate().equals(editedEvent.getDate()) &&
                            eventFromDb.get().getTime().equals(editedEvent.getTime()) &&
                            eventFromDb.get().getDuration().equals(editedEvent.getDuration())
                            &&
                            eventFromDb.get().getMaster().getId().equals(editedEvent.getMaster().getId())
                            &&
                            eventFromDb.get().getProcedure().getId().equals(editedEvent.getProcedure().getId())
                            &&
                            eventFromDb.get().getAdditionalInfo().equals(editedEvent.getAdditionalInfo())
            ) {
                result = true;
            }
        }

        return result;
    }

    public static boolean isEventDateOrMasterChange(Optional<Event> eventFromDb, EditEventRequest editedEvent) {
        boolean result = true;
        if (
                eventFromDb.get().getDate().equals(editedEvent.getDate()) ||
                        eventFromDb.get().getTime().equals(editedEvent.getTime()) ||
                        eventFromDb.get().getDuration().equals(editedEvent.getDuration()) ||
                        eventFromDb.get().getMaster().getId().equals(editedEvent.getMaster().getId())

        ) {
            result = false;
        }
        return result;
    }

    public static boolean isTimeFree(String date, String time, String duration, List<Event> events) {
        boolean result = false;
        if (events.size() == 0) {
            return result = true;
        } else {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            List<LocalDateTime> startApiArray = new ArrayList<>();
            List<LocalDateTime> endApiArray = new ArrayList<>();
            for (int i = 0; i < events.size(); i++) {
                LocalDate localDateApi = LocalDate.parse(events.get(i).getDate(), df);
                LocalTime localTimeApi = LocalTime.parse(events.get(i).getTime());
                LocalTime localDurationApi = LocalTime.parse(events.get(i).getDuration());
                Integer hourApi = localDurationApi.getHour();
                Integer minApi = localDurationApi.getMinute();
                LocalDateTime startApi = LocalDateTime.of(localDateApi, localTimeApi);
                LocalDateTime endApi = startApi.plusHours(hourApi).plusMinutes(minApi);
                startApiArray.add(startApi);
                endApiArray.add(endApi);
            }

            LocalDate localDate = LocalDate.parse(date, df);
            LocalTime localTime = LocalTime.parse(time);
            System.out.println("local time " + localTime);
            LocalTime localDuration = LocalTime.parse(duration);
            System.out.println("local duration " + localDuration);
            Integer hour = localDuration.getHour();
            Integer min = localDuration.getMinute();

            LocalDateTime start = LocalDateTime.of(localDate, localTime);
            LocalDateTime end = start.plusHours(hour).plusMinutes(min);
            System.out.println("Старт " + start);
            System.out.println("Конец " + end);
            System.out.println(startApiArray.size() > 3);
            System.out.println(localDuration.getHour());
            if (startApiArray.size() > 3 && localDuration.getHour() > 9) {
                System.out.println(startApiArray.size() > 3 || localDuration.isAfter(localTime));
                return result = false;
            } else {
                for (int i = 0; i < startApiArray.size(); i++) {
                    //Начало после начала от апи
                    System.out.println("Начало после начала от апи " + start.isAfter(startApiArray.get(i)));
                    if (start.isAfter(startApiArray.get(i))) {
                        //Начало раньше конца от апи
                        System.out.println("Начало раньше конца от апи " + start.isBefore(endApiArray.get(i)));
                        if (start.isBefore(endApiArray.get(i))) {
                            //Начало = концу от апи
                            System.out.println("Начало = концу от апи " + start.isEqual(endApiArray.get(i)));
                            if (start.isEqual(endApiArray.get(i))) {
                                System.out.println("Начало = концу от апи");
                                return result = true;

                            } else {
                                System.out.println("Начало раньше конца от апи");
                                return result = false;

                            }


                        } else {
                            //Конец раньше конца от апи
                            System.out.println("Конец раньше конца от апи " + end.isBefore(endApiArray.get(i)));
                            if (end.isBefore(endApiArray.get(i))) {
                                System.out.println("время окончания перед концом процедуры");
                                return result = false;

                            } else {
                                System.out.println("все огонь");
                                return result = true;

                            }
                        }

                    } else {
                        //Конец раньше начала от апи
                        System.out.println("Конец раньше начала от апи " + end.isBefore(startApiArray.get(i)));
                        if (end.isBefore(startApiArray.get(i))) {
                            System.out.println("вcе огонь");
                            return result = true;


                        } else if (end.isEqual(startApiArray.get(i))) {
                            System.out.println("Все огонь: время конца = времени начала процедуры");
                            return result = true;

                        } else {
                            System.out.println("время окончания после начала процедуры");
                            return result = false;

                        }
                    }

                }
            }


        }


        return result;
    }

    @PostMapping(path = "/addEvent",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    CreateEventResponse addEvent(@RequestBody EventRequest request) {
        Event event = new Event();
        if (request.getFreeDay()) {
            event.setDate(request.getDate());
            event.setTime("00:00");
            event.setDuration("23:00");
            event.setMaster(request.getMaster());
            event.setFreeDay(request.getFreeDay());
            if (!eventService.findEventByMasterAndDate(request.getMaster().getName(), request.getDate()).isEmpty()) {
                return new CreateEventResponse("error", "Есть записи на дату " + request.getDate());
            }
            eventService.addEvent(event);
            return new CreateEventResponse("success", "Выходной успешно добавлен");
        }
        event.setClientName(request.getClientName());
        event.setPhoneNumber(request.getPhoneNumber());
        event.setInstagram(request.getInstagram());
        event.setPrice(request.getPrice());
        if (request.getTime().equals("00:00")) {
            return new CreateEventResponse("error", "Время начала процедуры не выбрано");
        }
        event.setTime(request.getTime());
        event.setDate(request.getDate());
        if (request.getDuration().equals("00:00")) {
            return new CreateEventResponse("error", "Продолжительность процедуры не указана");
        }
        event.setDuration(request.getDuration());
        event.setMaster(request.getMaster());

        if (request.getProcedure() == null) {
            return new CreateEventResponse("error", "Процедура не указана");
        }
        event.setProcedure(request.getProcedure());
        List<Event> eventsByDateAndMaster = eventService.findEventByMasterAndDate(request.getMaster().getName(), request.getDate());
        if (!eventsByDateAndMaster.isEmpty()) {
            if (eventsByDateAndMaster.get(0).getFreeDay()) {
                return new CreateEventResponse("error", request.getDate() + " выходной у мастера " + request.getMaster().getName());
            }
            if (!isTimeFree(request.getDate(), request.getTime(), request.getDuration(), eventsByDateAndMaster)) {
                return new CreateEventResponse("error", "Это время занято");
            }
        }
        event.setAdditionalInfo(request.getAdditionalInfo());
        event.setFreeDay(request.getFreeDay());
        eventService.addEvent(event);
        return new CreateEventResponse("success", "Запись успешно добавлена");
    }

    @PostMapping(path = "/editEvent", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    EditEventResponse editEvent(@RequestBody @Valid EditEventRequest request) {
        Optional<Event> storedEvent = eventService.findById(request.getId().longValue());
        if (isEventsEquals(storedEvent, request)) {
            return new EditEventResponse("error", "Данные записи не изменились");
        }
        Event event = new Event();
        if (request.getFreeDay()) {
            event.setId(request.getId().longValue());
            event.setDate(request.getDate());
            event.setTime("00:00");
            event.setDuration("23:00");
            event.setMaster(request.getMaster());
            event.setFreeDay(request.getFreeDay());
            if (!eventService.findEventByMasterAndDate(request.getMaster().getName(), request.getDate()).isEmpty()) {
                return new EditEventResponse("error", "Есть записи на дату " + request.getDate());
            }
        } else {
            event.setId(request.getId().longValue());
            event.setClientName(request.getClientName());
            event.setPhoneNumber(request.getPhoneNumber());
            event.setInstagram(request.getInstagram());
            event.setPrice(request.getPrice());
            event.setTime(request.getTime());
            event.setDate(request.getDate());
            event.setDuration(request.getDuration());
            event.setMaster(request.getMaster());
            if (request.getProcedure() == null) {
                return new EditEventResponse("error", "Процедура не указана");
            }
            event.setProcedure(request.getProcedure());
            event.setAdditionalInfo(request.getAdditionalInfo());
        }
        List<Event> eventsByDateAndMaster = eventService.findEventByMasterAndDate(request.getMaster().getName(), request.getDate());
        if (isEventDateOrMasterChange(storedEvent, request)) {
            if (!isTimeFree(request.getDate(), request.getTime(), request.getDuration(), eventsByDateAndMaster)) {
                return new EditEventResponse("error", "Это время занято");
            }
        }
        eventService.addEvent(event);
        return new EditEventResponse("success", "Запись успешно изменена");
    }

    @GetMapping("/event/remove/{id}")
    public RemoveEventResponse removeEvent(@PathVariable(value = "id") String eventId) {

        eventService.removeEvent(new Long(eventId));
        return new RemoveEventResponse("success", "Запись успешно удалена");
    }





}

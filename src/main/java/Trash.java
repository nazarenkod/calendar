public class Trash {


//     if (items.isEmpty()) {
//            CalendarEvent calendarEvent = new CalendarEvent();
//            calendarEvent.setSummary("No upcoming events found.");
//            eventsList.add(calendarEvent);
//        } else {
//            for (Event event : items) {
//                DateTime start = event.getStart().getDateTime();
//                DateTime end = event.getEnd().getDateTime();
//                if (start == null || end == null) {
//                    start = event.getStart().getDate();
//                    end = event.getEnd().getDate();
//                }
//
//                Date startTime = new Date(start.getValue());
//                Date endTime = new Date(end.getValue());
//
//                SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy/HH:mm");
//                String startDateTime = formater.format(startTime);
//                String endDateTime = formater.format(endTime);
//                CalendarEvent calendarEvent = new CalendarEvent();
//                ua.beauty.calendar.domain.EventDateTime eventDateTime = new ua.beauty.calendar.domain.EventDateTime();
//                eventDateTime.setDate(startDateTime.substring(0,10));
//                eventDateTime.setStartTime(startDateTime.substring(11,16));
//                eventDateTime.setEndTime(endDateTime.substring(11,16));
//                calendarEvent.setEventDateTime(eventDateTime);
//                calendarEvent.setEventId(event.getId());
//                eventsList.add(calendarEvent);
//            }
//        }
}

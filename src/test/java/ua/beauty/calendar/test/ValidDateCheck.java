package ua.beauty.calendar.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.beauty.calendar.domain.Event;
import ua.beauty.calendar.domain.Master;
import ua.beauty.calendar.domain.Procedure;

import java.util.ArrayList;
import java.util.List;

import static ua.beauty.calendar.api.EventController.isTimeFree;


public class ValidDateCheck {

    private List<Event> events;

    @Before
    public void createEvents() {

        events = new ArrayList<>();
        events.add(new Event(new Long(1), "Клиент", "телефон", "insta", "3000", "07.04.2020", "08:00", "01:00", new Master(new Long(1), "Полина"), new Procedure(new Long(1), "Окрашивание"), "", false));
        events.add(new Event(new Long(2), "Клиент", "телефон", "insta", "3000", "07.04.2020", "17:00", "01:00", new Master(new Long(1), "Полина"), new Procedure(new Long(1), "Окрашивание"), "", false));
        events.add(new Event(new Long(3), "Клиент", "телефон", "insta", "3000", "07.04.2020", "09:00", "01:00", new Master(new Long(1), "Полина"), new Procedure(new Long(1), "Окрашивание"), "", false));
        events.add(new Event(new Long(4), "Клиент", "телефон", "insta", "3000", "07.04.2020", "12:00", "01:00", new Master(new Long(1), "Полина"), new Procedure(new Long(1), "Окрашивание"), "", false));
    }


    @Test
    public void emptyEventArray() {
        String date = "07.04.2020";
        String time = "08:39";
        String duration = "00:29";
        List<Event> events = new ArrayList<>();
        Assert.assertTrue(isTimeFree(date, time, duration, events));
    }

    @Test
    public void test1() {
        String date = "07.04.2020";
        String time = "07:00";
        String duration = "00:59";
        Assert.assertTrue(isTimeFree(date, time, duration, events));
    }

    @Test
    public void test2() {
        String date = "07.04.2020";
        String time = "07:00";
        String duration = "01:00";
        Assert.assertTrue(isTimeFree(date, time, duration, events));
    }

    @Test
    public void test3() {
        String date = "07.04.2020";
        String time = "10:00";
        String duration = "02:00";
        Assert.assertTrue(isTimeFree(date, time, duration, events));
    }

    @Test
    public void test4() {
        String date = "07.04.2020";
        String time = "13:01";
        String duration = "03:58";
        Assert.assertTrue(isTimeFree(date, time, duration, events));
    }

    @Test
    public void test5() {
        String date = "07.04.2020";
        String time = "18:00";
        String duration = "04:00";
        Assert.assertTrue(isTimeFree(date, time, duration, events));
    }


    @Test
    public void test6() {
        String date = "07.04.2020";
        String time = "07:00";
        String duration = "01:10";
        System.out.println("res " + isTimeFree(date, time, duration, events));
        Assert.assertFalse(isTimeFree(date, time, duration, events));

    }

    @Test
    public void test7() {
        String date = "07.04.2020";
        String time = "07:30";
        String duration = "03:00";
        Assert.assertFalse(isTimeFree(date, time, duration, events));
    }

    @Test
    public void test8() {
        String date = "07.04.2020";
        String time = "08:01";
        String duration = "00:49";
        Assert.assertFalse(isTimeFree(date, time, duration, events));
    }

    @Test
    public void test9() {
        String date = "07.04.2020";
        String time = "08:00";
        String duration = "03:00";
        Assert.assertFalse(isTimeFree(date, time, duration, events));
    }

    @Test
    public void test10() {
        String date = "07.04.2020";
        String time = "11:00";
        String duration = "12:00";
        Assert.assertFalse(isTimeFree(date, time, duration, events));
    }


}

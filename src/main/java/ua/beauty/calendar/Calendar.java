package ua.beauty.calendar;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
public class Calendar {


    public static void main(String[] args) {
        SpringApplication.run(Calendar.class,args);
    }




}

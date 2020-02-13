package ua.beauty.calendar;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import ua.beauty.calendar.dao.MasterDao;


//@SpringBootApplication(scanBasePackages={"calendar"})
@SpringBootApplication
@EnableJpaRepositories
public class Calendar {



//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        return sessionFactory;
//    }
    public static void main(String[] args) {
        SpringApplication.run(Calendar.class,args);
    }




}

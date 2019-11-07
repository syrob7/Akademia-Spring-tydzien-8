package pl.akademiaspring.week8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Week8Application {

    public static void main(String[] args) {
        SpringApplication.run(Week8Application.class, args);
    }

}

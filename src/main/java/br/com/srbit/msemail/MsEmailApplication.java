package br.com.srbit.msemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableKafka
@SpringBootApplication
public class MsEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsEmailApplication.class, args);
    }

}
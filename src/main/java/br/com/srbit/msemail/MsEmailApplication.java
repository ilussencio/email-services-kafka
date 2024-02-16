package br.com.srbit.msemail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableKafka
@EnableMongoRepositories
@SpringBootApplication
public class MsEmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsEmailApplication.class, args);
    }

}
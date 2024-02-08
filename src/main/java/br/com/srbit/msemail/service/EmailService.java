package br.com.srbit.msemail.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@AllArgsConstructor

@Log4j2
public class EmailService {
    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    public void sendEmail(Serializable emailModel){
        log.info("Sending email to kafka topic {}", emailModel);
        kafkaTemplate.send("email-topic", emailModel);
    }
}

package br.com.srbit.msemail.service;

import br.com.srbit.msemail.model.EmailModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EmailServicerConsumer {
    @KafkaListener(topics = "email-topic", groupId = "group_id",containerFactory = "jsonContainerFactory")
    public void consumerMessage(@Payload EmailModel emailModel){
        log.info("Email sent to: {}", emailModel.getTo());
    }
}

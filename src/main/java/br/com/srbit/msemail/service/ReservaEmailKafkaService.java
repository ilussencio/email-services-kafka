package br.com.srbit.msemail.service;

import br.com.srbit.msemail.enumeration.StatusEmail;
import br.com.srbit.msemail.models.EmailModel;
import br.com.srbit.msemail.record.ReservaRecord;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Service
public class ReservaEmailKafkaService {

    private static final String PATTERN_FORMAT = "dd/MM/yyyy";
    private final TemplateEngine templateEngine;
    private final EmailService emailService;


    @KafkaListener(topics = "reserva-email-topic", groupId = "group_id",containerFactory = "jsonContainerFactory")
    public void consumerMessage(@Payload ReservaRecord reservaModel){
        System.out.println(reservaModel.clienteModel().email());

        if(reservaModel == null || reservaModel.clienteModel().email() == null){
            return;
        }

        Context context = new Context();
        context.setVariable("nome",reservaModel.clienteModel().nome());
        context.setVariable("marca",reservaModel.carroModel().marca());
        context.setVariable("modelo",reservaModel.carroModel().modelo());
        context.setVariable("placa",reservaModel.carroModel().placa());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());
        Instant instant = reservaModel.dataLocacao();
        String formattedInstant = formatter.format(instant);
        context.setVariable("data",formattedInstant);
        context.setVariable("qtdDias",reservaModel.qtdDias());
        context.setVariable("valor",reservaModel.valorTotal());
        String htmlContent = templateEngine.process("email-template-reserva", context);

        EmailModel emailModel = new EmailModel();
        emailModel.setEmailFrom("no-reply@gmail.com");
        emailModel.setEmailTo(reservaModel.clienteModel().email());
        emailModel.setSubject("Reserva de Carro");
        emailModel.setHtmlContent(htmlContent);
        emailModel.setStatus(StatusEmail.PROCESSING);

        emailService.sendEmail(emailModel);
    }

}

package br.com.srbit.msemail.service;

import br.com.srbit.msemail.model.ReservaModel;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@Log4j2
public class ReservaEmailService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    public ReservaEmailService(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;

    }

    @KafkaListener(topics = "reserva-email-topic", groupId = "group_id",containerFactory = "jsonContainerFactory")
    public void consumerMessage(@Payload ReservaModel reservaModel){

        if(reservaModel.getClienteModel().getEmail() == null)
            return;

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
        try {
            Context context = new Context();
            context.setVariable("nome","Lucas Ilussencio da silva");
            context.setVariable("marca","Volkswagen");
            context.setVariable("modelo","Gol g6");
            context.setVariable("placa","OXG-8212");

            context.setVariable("data","08/02/2024");
            context.setVariable("qtdDias","10");
            context.setVariable("valor","1500.00");




            helper.setTo("no-reply@srbit.com.br");
            helper.setSubject("Assunto do email");
            String htmlContent = templateEngine.process("email-template-reserva", context);
            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            System.out.println("Eroror!");
        }



//        var message = new SimpleMailMessage();
//        message.setFrom("no-reply@srbit.com.br");
//        message.setTo(reservaModel.getClienteModel().getEmail());
//        message.setSubject("Assunto do email");
//        message.setText("Corpo do email");
//        mailSender.send(message);

        log.info(reservaModel.getClienteModel().getEmail());
    }

}

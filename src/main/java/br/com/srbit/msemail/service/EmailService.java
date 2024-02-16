package br.com.srbit.msemail.service;

import br.com.srbit.msemail.enumeration.StatusEmail;
import br.com.srbit.msemail.models.EmailModel;
import br.com.srbit.msemail.models.dto.EmailDTO;
import br.com.srbit.msemail.repositories.EmailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.time.Instant;

@AllArgsConstructor
@Service
public class EmailService {
    private final EmailRepository repository;
    private final JavaMailSender mailSender;

    public void sendEmail(EmailModel emailModel){
        emailModel.setSendDateEmail(Instant.now());

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try{
            helper.setTo(emailModel.getEmailTo());
            helper.setSubject(emailModel.getSubject());
            helper.setText(emailModel.getHtmlContent(), true);
            mailSender.send(mimeMessage);

            emailModel.setStatus(StatusEmail.SENT);
        }catch (MessagingException e){
            emailModel.setStatus(StatusEmail.ERROR);
        }finally {
            repository.save(emailModel);
        }
    }

    public Page<EmailDTO> findAll(Pageable pageable){
        return repository.findAll(pageable).map(EmailDTO::new);
    }

    public EmailDTO findById(ObjectId objectId){
        return new EmailDTO(repository.findById(String.valueOf(objectId)).orElseThrow());
    }

}

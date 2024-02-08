package br.com.srbit.msemail.controller;

import br.com.srbit.msemail.model.EmailModel;
import br.com.srbit.msemail.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<EmailModel> sendEmail(){
        EmailModel emailModel = new EmailModel();
        emailModel.setFrom("ilussencio@gmail.com");
        emailModel.setTo("ilussencio@proton.mail");
        emailModel.setSubject("Teste de envio de email");
        emailModel.setMessage("Teste de envio de email com kafka");
        emailService.sendEmail(emailModel);
        return ResponseEntity.ok(emailModel);
    }

}

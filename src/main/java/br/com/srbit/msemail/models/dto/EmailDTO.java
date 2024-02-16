package br.com.srbit.msemail.models.dto;

import br.com.srbit.msemail.enumeration.StatusEmail;
import br.com.srbit.msemail.models.EmailModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EmailDTO implements Serializable {
    private String emailId;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String htmlContent;
    private Instant sendDateEmail;
    private StatusEmail status;

    public EmailDTO (EmailModel emailModel){
        if(emailModel.getEmailId() != null)
            this.emailId = emailModel.getEmailId().toString();
        this.emailFrom = emailModel.getEmailFrom();
        this.emailTo = emailModel.getEmailTo();
        this.subject = emailModel.getSubject();
        this.htmlContent = emailModel.getHtmlContent();
        this.sendDateEmail = emailModel.getSendDateEmail();
        this.status = emailModel.getStatus();
    }
}

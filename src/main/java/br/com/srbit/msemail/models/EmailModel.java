package br.com.srbit.msemail.models;

import br.com.srbit.msemail.enumeration.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "collection-email")
public class EmailModel {
    @Id
    private ObjectId emailId;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String htmlContent;
    private Instant sendDateEmail;
    private StatusEmail status;
}

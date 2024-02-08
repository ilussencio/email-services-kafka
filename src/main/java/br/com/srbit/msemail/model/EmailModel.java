package br.com.srbit.msemail.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class EmailModel implements Serializable {

    private String from;
    private String to;
    private String message;
    private String subject;
}

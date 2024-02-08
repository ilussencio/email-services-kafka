package br.com.srbit.msemail.model;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID idCliente;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private Instant create_at;
    private Instant update_at;
}

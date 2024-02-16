package br.com.srbit.msemail.record;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public record ClienteRecord(
        UUID idCliente,
        String nome,
        String telefone,
        String email,
        String cpf,
        Instant create_at,
        Instant update_at
)implements Serializable {}

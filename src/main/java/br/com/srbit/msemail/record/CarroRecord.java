package br.com.srbit.msemail.record;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record CarroRecord(
        UUID idCarro,
        String marca,
        String modelo,
        String placa,
        BigDecimal preco,
        Instant create_at,
        Instant update_at
) implements Serializable {}

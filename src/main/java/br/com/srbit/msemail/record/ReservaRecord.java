package br.com.srbit.msemail.record;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record ReservaRecord(
        UUID idReserva,
        CarroRecord carroModel,
        ClienteRecord clienteModel,
        Instant dataLocacao,
        int qtdDias,
        BigDecimal valorTotal,
        Instant create_at,
        Instant update_at
) implements Serializable {
}

package br.com.srbit.msemail.model;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class ReservaModel implements Serializable {
    private static final long serialVersionUID = 1L;


    private UUID idReserva;


    private CarroModel carroModel;


    private ClienteModel clienteModel;

    private Instant dataLocacao;
    private int qtdDias;
    private BigDecimal valorTotal;


    private Instant create_at;


    private Instant update_at;
}

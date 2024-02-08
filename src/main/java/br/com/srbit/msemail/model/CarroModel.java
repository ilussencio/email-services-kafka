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

public class CarroModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID idCarro;

    private String marca;
    private String modelo;

    private String placa;
    private BigDecimal preco;


    private Instant create_at;


    private Instant update_at;
}

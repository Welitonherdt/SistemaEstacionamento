package br.edu.famper.sistemaestacionamento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "tbl_pagamento")
@Data
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pagamento_id")
    private Long codigo;

    @Column(name = "valor")
    private String Double;

    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "forma_pagamento", length = 50)
    private String formaPagamento;

    @Column(name = "email", length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
}

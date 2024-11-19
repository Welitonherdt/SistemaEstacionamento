package br.edu.famper.sistemaestacionamento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


    @Entity
    @Table(name= "tbl_veiculo")
    @Data
    public class Veiculo {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "veiculo_id")
        private Long codigo;

        @Column(name = "marca", length = 100)
        private String marca;

        @Column(name = "modelo", length = 100)
        private String modelo;

        @Column(name = "ano_fabricacao")
        @Temporal(TemporalType.DATE)
        private Date anoFabricacao;


        @Column(name = "cor", length = 20)
        private String cor;

        @Column(name = "placa", length = 20)
        private String placa;

        @ManyToOne
        @JoinColumn(name = "proprietario_id")
        private Cliente proprietario;



    }

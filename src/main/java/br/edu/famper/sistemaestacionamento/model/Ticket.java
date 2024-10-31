package br.edu.famper.sistemaestacionamento.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name= "tbl_ticket")
@Data
public class Ticket {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @Column(name = "ticket_id")
        private Long codigo;

        @Column(name = "data_criacao")
        @Temporal(TemporalType.DATE)
        private Date dataCriacao;

        @Column(name = "data_atualizacao")
        @Temporal(TemporalType.DATE)
        private Date dataAtualizacao;

        @Column(name = "status", length = 50)
        private String status;

        @Column(name = "prioridade", length = 100)
        private String prioridade;

        @ManyToOne
        @JoinColumn(name = "cliente_id")
        private Cliente cliente;

        @ManyToOne
        @JoinColumn(name = "veiculo_id")
        private  Veiculo veiculo;

        @ManyToOne
        @JoinColumn(name = "vaga_id")
        private Vaga vaga;

        @OneToMany(mappedBy = "ticket", targetEntity = Pagamento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JsonIgnore
        private Set<Pagamento> pagamentos;

}

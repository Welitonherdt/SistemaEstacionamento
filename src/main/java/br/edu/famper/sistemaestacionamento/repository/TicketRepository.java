package br.edu.famper.sistemaestacionamento.repository;

import br.edu.famper.sistemaestacionamento.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}

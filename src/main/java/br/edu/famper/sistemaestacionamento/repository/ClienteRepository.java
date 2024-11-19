package br.edu.famper.sistemaestacionamento.repository;

import br.edu.famper.sistemaestacionamento.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}

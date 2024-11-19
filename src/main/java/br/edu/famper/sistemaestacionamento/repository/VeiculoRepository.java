package br.edu.famper.sistemaestacionamento.repository;

import br.edu.famper.sistemaestacionamento.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}

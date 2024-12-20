package br.edu.famper.sistemaestacionamento.repository;

import br.edu.famper.sistemaestacionamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}

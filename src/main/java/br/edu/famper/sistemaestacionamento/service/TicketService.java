package br.edu.famper.sistemaestacionamento.service;

import br.edu.famper.sistemaestacionamento.dto.TicketDto;
import br.edu.famper.sistemaestacionamento.dto.TicketDto;
import br.edu.famper.sistemaestacionamento.model.Ticket;
import br.edu.famper.sistemaestacionamento.model.Ticket;
import br.edu.famper.sistemaestacionamento.repository.TicketRepository;
import br.edu.famper.sistemaestacionamento.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public List<TicketDto> getAllTickets(){
        return ticketRepository
                .findAll()
                .stream()
                .map(ticket -> TicketDto
                        .builder()
                        .data_criacao(ticket.getDataCriacao())
                        .data_atualizacao(ticket.getDataAtualizacao())
                        .status(ticket.getStatus())
                        .prioridade(ticket.getPrioridade())
                        .build()
                )
                .toList();
    }

    // buscar uma ticket
    public TicketDto getTicketById(Long id){
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        return new TicketDto()
                .builder()
                .data_criacao(ticket.getDataCriacao())
                .data_atualizacao(ticket.getDataAtualizacao())
                .status(ticket.getStatus())
                .prioridade(ticket.getPrioridade())
                .build();
    }

    // inserir uma ticket
    public Ticket saveTicket(Ticket ticket){
//        Ticket ticket = new Ticket();
//        ticket.setDataCriacao(ticketDto.getData_criacao());
//        ticket.setDataAtualizacao(ticketDto.getData_atualizacao());
//        ticket.setStatus(ticketDto.getStatus());
//        ticket.setPrioridade(ticketDto.getPrioridade());
        return ticketRepository.save(ticket);
    }

    // editar uma ticket
    public TicketDto editTicket(Long id, TicketDto ticketDto){
        Ticket ticket = ticketRepository.findById(id).orElseThrow();
        ticket.setDataCriacao(ticketDto.getData_criacao());
        ticket.setDataAtualizacao(ticketDto.getData_atualizacao());
        ticket.setStatus(ticketDto.getStatus());
        ticket.setPrioridade(ticketDto.getPrioridade());
        Ticket ticketEdited = ticketRepository.save(ticket);
        return new TicketDto()
                .builder()
                .data_criacao(ticketEdited.getDataCriacao())
                .data_atualizacao(ticketEdited.getDataAtualizacao())
                .status(ticketEdited.getStatus())
                .prioridade(ticketEdited.getPrioridade())
                .build();
    }

    // apagar uma ticket
    public boolean deleteTicket(Long id){
        try{
            Ticket ticket = ticketRepository.findById(id).orElseThrow();
            ticketRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}

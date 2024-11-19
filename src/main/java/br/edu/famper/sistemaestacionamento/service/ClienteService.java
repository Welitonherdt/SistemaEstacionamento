package br.edu.famper.sistemaestacionamento.service;

import br.edu.famper.sistemaestacionamento.dto.ClienteDto;
import br.edu.famper.sistemaestacionamento.dto.ClienteDto;
import br.edu.famper.sistemaestacionamento.model.Cliente;
import br.edu.famper.sistemaestacionamento.model.Cliente;
import br.edu.famper.sistemaestacionamento.repository.ClienteRepository;
import br.edu.famper.sistemaestacionamento.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDto> getAllClientes(){
        return clienteRepository
                .findAll()
                .stream()
                .map(cliente -> ClienteDto
                        .builder()
                        .nome(cliente.getNome())
                        .telefone(cliente.getTelefone())
                        .email(cliente.getEmail())
                        .endereco(cliente.getEndereco())
                        .build()
                )
                .toList();
    }

    // buscar uma cliente
    public ClienteDto getClienteById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        return new ClienteDto()
                .builder()
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .email(cliente.getEmail())
                .endereco(cliente.getEndereco())
                .build();
    }

    // inserir uma cliente
    public Cliente saveCliente(Cliente cliente){
//        Cliente cliente = new Cliente();
//        cliente.setNome(clienteDto.getNome());
//        cliente.setTelefone(clienteDto.getTelefone());
//        cliente.setEmail(clienteDto.getEmail());
//        cliente.setEndereco(clienteDto.getEndereco());
        return clienteRepository.save(cliente);
    }

    // editar uma cliente
    public ClienteDto editCliente(Long id, ClienteDto clienteDto){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNome(clienteDto.getNome());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setEndereco(clienteDto.getEndereco());
        Cliente clienteEdited = clienteRepository.save(cliente);
        return new ClienteDto()
                .builder()
                .nome(clienteEdited.getNome())
                .telefone(clienteEdited.getTelefone())
                .email(clienteEdited.getEmail())
                .endereco(clienteEdited.getEndereco())
                .build();
    }

    // apagar uma cliente
    public boolean deleteCliente(Long id){
        try{
            Cliente cliente = clienteRepository.findById(id).orElseThrow();
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}

package br.edu.famper.sistemaestacionamento.service;


import br.edu.famper.sistemaestacionamento.dto.VagaDto;
import br.edu.famper.sistemaestacionamento.model.Vaga;
import br.edu.famper.sistemaestacionamento.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public List<VagaDto> getAllVagas(){
        return vagaRepository
                .findAll()
                .stream()
                .map(vaga -> VagaDto
                        .builder()
                        .data_criacao(vaga.getDataCriacao())
                        .data_atualizacao(vaga.getDataAtualizacao())
                        .localizacao(vaga.getLocalizacao())
                        .tipo(vaga.getTipo())
                        .build()
                )
                .toList();
    }

    // buscar uma vaga
    public VagaDto getVagaById(Long id){
        Vaga vaga = vagaRepository.findById(id).orElseThrow();
        return new VagaDto()
                .builder()
                .data_criacao(vaga.getDataCriacao())
                .data_atualizacao(vaga.getDataAtualizacao())
                .localizacao(vaga.getLocalizacao())
                .tipo(vaga.getTipo())
                .build();
    }

    // inserir uma vaga
    public Vaga saveVaga(Vaga vaga){
//        Vaga vaga = new Vaga();
//        vaga.setDataCriacao(vagaDto.getData_criacao());
//        vaga.setDataAtualizacao(vagaDto.getData_atualizacao());
//        vaga.setLocalizacao(vagaDto.getLocalizacao());
//        vaga.setTipo(vagaDto.getTipo().toString());
        return vagaRepository.save(vaga);
    }

    // editar uma vaga
    public VagaDto editVaga(Long id, VagaDto vagaDto){
        Vaga vaga = vagaRepository.findById(id).orElseThrow();
        vaga.setDataCriacao(vagaDto.getData_criacao());
        vaga.setDataAtualizacao(vagaDto.getData_atualizacao());
        vaga.setLocalizacao(vagaDto.getLocalizacao());
        vaga.setTipo(vagaDto.getTipo().toString());
        Vaga vagaEdited = vagaRepository.save(vaga);
        return new VagaDto()
                .builder()
                .data_criacao(vagaEdited.getDataCriacao())
                .data_atualizacao(vagaEdited.getDataAtualizacao())
                .localizacao(vagaEdited.getLocalizacao())
                .tipo(vagaEdited.getTipo())
                .build();
    }

    // apagar uma vaga
    public boolean deleteVaga(Long id){
        try{
            Vaga vaga = vagaRepository.findById(id).orElseThrow();
            vagaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}

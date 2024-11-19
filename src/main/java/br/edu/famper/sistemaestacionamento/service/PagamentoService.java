package br.edu.famper.sistemaestacionamento.service;

import br.edu.famper.sistemaestacionamento.dto.PagamentoDto;
import br.edu.famper.sistemaestacionamento.dto.PagamentoDto;
import br.edu.famper.sistemaestacionamento.model.Pagamento;
import br.edu.famper.sistemaestacionamento.model.Pagamento;
import br.edu.famper.sistemaestacionamento.repository.PagamentoRepository;
import br.edu.famper.sistemaestacionamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoDto> getAllPagamentos(){
        return pagamentoRepository
                .findAll()
                .stream()
                .map(pagamento -> PagamentoDto
                        .builder()
                        .valor(pagamento.getValor())
                        .data_pagamento(pagamento.getDataPagamento())
                        .forma_pagamento(pagamento.getFormaPagamento())
                        .email(pagamento.getEmail())
                        .status(pagamento.getStatus())
                        .build()
                )
                .toList();
    }

    // buscar uma pagamento
    public PagamentoDto getPagamentoById(Long id){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow();
        return new PagamentoDto()
                .builder()
                .valor(pagamento.getValor())
                .data_pagamento(pagamento.getDataPagamento())
                .forma_pagamento(pagamento.getFormaPagamento())
                .email(pagamento.getEmail())
                .status(pagamento.getStatus())
                .build();
    }

    // inserir uma pagamento
    public Pagamento savePagamento(Pagamento pagamento){
//        Pagamento pagamento = new Pagamento();
//        pagamento.setValor(pagamentoDto.getValor());
//        pagamento.setDataPagamento(pagamentoDto.getData_pagamento());
//        pagamento.setFormaPagamento(pagamentoDto.getForma_pagamento());
//        pagamento.setEmail(pagamentoDto.getEmail());
//        pagamento.setStatus(pagamentoDto.getStatus());
        return pagamentoRepository.save(pagamento);
    }

    // editar uma pagamento
    public PagamentoDto editPagamento(Long id, PagamentoDto pagamentoDto){
        Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow();
        pagamento.setValor(pagamentoDto.getValor());
        pagamento.setDataPagamento(pagamentoDto.getData_pagamento());
        pagamento.setFormaPagamento(pagamentoDto.getForma_pagamento());
        pagamento.setEmail(pagamentoDto.getEmail());
        pagamento.setStatus(pagamentoDto.getStatus());
        Pagamento pagamentoEdited = pagamentoRepository.save(pagamento);
        return new PagamentoDto()
                .builder()
                .valor(pagamentoEdited.getValor())
                .data_pagamento(pagamentoEdited.getDataPagamento())
                .forma_pagamento(pagamentoEdited.getFormaPagamento())
                .email(pagamentoEdited.getEmail())
                .status(pagamentoEdited.getStatus())
                .build();
    }

    // apagar uma pagamento
    public boolean deletePagamento(Long id){
        try{
            Pagamento pagamento = pagamentoRepository.findById(id).orElseThrow();
            pagamentoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}


package br.edu.famper.sistemaestacionamento.service;



import br.edu.famper.sistemaestacionamento.dto.VeiculoDto;
import br.edu.famper.sistemaestacionamento.dto.VeiculoDto;
import br.edu.famper.sistemaestacionamento.model.Veiculo;
import br.edu.famper.sistemaestacionamento.model.Veiculo;
import br.edu.famper.sistemaestacionamento.repository.VeiculoRepository;
import br.edu.famper.sistemaestacionamento.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoDto> getAllVeiculos(){
        return veiculoRepository
                .findAll()
                .stream()
                .map(veiculo -> VeiculoDto
                        .builder()
                        .marca(veiculo.getMarca())
                        .modelo(veiculo.getModelo())
                        .ano_fabricacao(veiculo.getAnoFabricacao())
                        .cor(veiculo.getCor())
                        .placa(veiculo.getPlaca())
                        .build()
                )
                .toList();
    }

    // buscar uma veiculo
    public VeiculoDto getVeiculoById(Long id){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow();
        return new VeiculoDto()
                .builder()
                .marca(veiculo.getMarca())
                .modelo(veiculo.getModelo())
                .ano_fabricacao(veiculo.getAnoFabricacao())
                .cor(veiculo.getCor())
                .placa(veiculo.getPlaca())
                .build();
    }

    // inserir uma veiculo
    public Veiculo saveVeiculo(Veiculo veiculo){
//        Veiculo veiculo = new Veiculo();
//        veiculo.setMarca(veiculoDto.getMarca());
//        veiculo.setModelo(veiculoDto.getModelo());
//        veiculo.setAnoFabricacao(veiculoDto.getAno_fabricacao());
//        veiculo.setCor(veiculoDto.getCor().toString());
//        veiculo.setPlaca(veiculoDto.getPlaca());
//        veiculo.setProprietario(veiculo.getProprietario());
        return veiculoRepository.save(veiculo);
    }

    // editar uma veiculo
    public VeiculoDto editVeiculo(Long id, VeiculoDto veiculoDto){
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow();
        veiculo.setMarca(veiculoDto.getMarca());
        veiculo.setModelo(veiculoDto.getModelo());
        veiculo.setAnoFabricacao(veiculoDto.getAno_fabricacao());
        veiculo.setCor(veiculoDto.getCor().toString());
        veiculo.setPlaca(veiculoDto.getPlaca());
        Veiculo veiculoEdited = veiculoRepository.save(veiculo);
        return new VeiculoDto()
                .builder()
                .marca(veiculoEdited.getMarca())
                .modelo(veiculoEdited.getModelo())
                .ano_fabricacao(veiculoEdited.getAnoFabricacao())
                .cor(veiculoEdited.getCor())
                .placa(veiculoEdited.getPlaca())
                .build();
    }

    // apagar uma veiculo
    public boolean deleteVeiculo(Long id){
        try{
            Veiculo veiculo = veiculoRepository.findById(id).orElseThrow();
            veiculoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}

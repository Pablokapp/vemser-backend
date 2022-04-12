package com.dbc.veiculoprodutorconsumidor.service;

import com.dbc.veiculoprodutorconsumidor.dtos.RegistroCreateDTO;
import com.dbc.veiculoprodutorconsumidor.dtos.RegistroDTO;
import com.dbc.veiculoprodutorconsumidor.entity.Registro;
import com.dbc.veiculoprodutorconsumidor.repository.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RegistroService {


    private final RegistroRepository registroRepository;

    public void salvar(RegistroCreateDTO registroCreateDTO) {
        Registro registro = new Registro();
        BeanUtils.copyProperties(registroCreateDTO, registro);
        registro.setDataLeitura(LocalDateTime.now());
        registroRepository.save(registro);
    }

    public List<RegistroDTO> listar() {
        return registroRepository.findAll().stream().map(registro -> {
            RegistroDTO registroDTO = new RegistroDTO();
            BeanUtils.copyProperties(registro, registroDTO);
            return registroDTO;
        }).collect(Collectors.toList());
    }


    public Double velocidadeMedia() {
        return registroRepository.findVelocidadeMedia();
    }

    public Double mediaRotacao(){
        return registroRepository.mediaRotacao();
    }

    public long qtdLeituras(){
        return registroRepository.count();
    }





}

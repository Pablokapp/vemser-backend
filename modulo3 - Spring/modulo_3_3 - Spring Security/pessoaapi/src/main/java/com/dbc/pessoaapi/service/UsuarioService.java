package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.entity.Roles;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.GrupoRepository;
import com.dbc.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final GrupoService groupService;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public LoginDTO criarUsuario(LoginDTO loginDTO, List<Roles> rolesAdicionar) throws RegraDeNegocioException {

        UsuarioEntity usuario = objectMapper.convertValue(loginDTO, UsuarioEntity.class);
        Set<GrupoEntity> regras = new HashSet<>();
        for (Roles roles : rolesAdicionar) {
            GrupoEntity grupoEntity = groupService.getById(roles.getRole());
            regras.add(grupoEntity);
        }

        usuario.setGrupos(regras);
        usuario.setSenha(new BCryptPasswordEncoder().encode(loginDTO.getSenha()));

        UsuarioEntity usuarioCriado = usuarioRepository.save(usuario);

        return objectMapper.convertValue(usuarioCriado, LoginDTO.class);
    }

}






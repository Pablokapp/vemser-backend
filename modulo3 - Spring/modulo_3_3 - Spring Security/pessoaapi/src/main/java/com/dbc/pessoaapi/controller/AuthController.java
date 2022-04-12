package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.LoginDTO;
import com.dbc.pessoaapi.dto.LoginDTOToken;
import com.dbc.pessoaapi.entity.RegraEntity;
import com.dbc.pessoaapi.entity.Roles;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.security.AuthenticationService;
import com.dbc.pessoaapi.security.TokenService;
import com.dbc.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;

    @PostMapping()
    public String auth(@RequestBody @Valid LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getLogin(),
                        loginDTO.getSenha()
                );

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        String token = tokenService.getToken(authenticate);
        return token;
    }

    @PostMapping("/criar-usuario")
    public LoginDTOToken criarUsuario(@RequestBody @Valid LoginDTO loginDTO, @RequestParam List<Roles> regras) throws RegraDeNegocioException {
        usuarioService.criarUsuario(loginDTO, regras);
        String token = auth(loginDTO);
        LoginDTOToken loginDTOToken = new LoginDTOToken();
        loginDTOToken.setLogin(loginDTO.getLogin());
        loginDTOToken.setToken(token);
        return loginDTOToken;
    }
}


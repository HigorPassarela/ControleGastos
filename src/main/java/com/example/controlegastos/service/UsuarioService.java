package com.example.controlegastos.service;

import com.example.controlegastos.model.usuarios.Usuario;
import com.example.controlegastos.model.usuarios.request.UsuarioRequest;
import com.example.controlegastos.model.usuarios.response.UsuarioResponse;
import com.example.controlegastos.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Cadastrar Usuario
    public UsuarioResponse CadastrarUsuario(@Valid UsuarioRequest dados){

        Usuario usuario = Usuario.builder()
                .nome(dados.nome())
                .email(dados.email())
                .senha(dados.senha())
                .build();

        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }
}

package com.example.controlegastos.service;

import com.example.controlegastos.model.usuarios.Usuario;
import com.example.controlegastos.model.usuarios.request.LoginRequest;
import com.example.controlegastos.model.usuarios.request.UsuarioRequest;
import com.example.controlegastos.model.usuarios.response.UsuarioResponse;
import com.example.controlegastos.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //Cadastrar Usuario
    @Transactional
    public UsuarioResponse CadastrarUsuario(@Valid UsuarioRequest dados){

        Usuario usuario = Usuario.builder()
                .nome(dados.nome())
                .email(dados.email())
                .senha(passwordEncoder.encode(dados.senha()))
                .build();

        usuarioRepository.save(usuario);
        return new UsuarioResponse(usuario);
    }

    //Validar senha para login
    @Transactional
    public boolean validarLogin(String senhaInformada, String SenhaHash){
        return  passwordEncoder.matches(senhaInformada,SenhaHash);
    }

    //Login
    @Transactional
    public UsuarioResponse login(LoginRequest dados){

        Usuario usuario = usuarioRepository.findByEmail(dados.email())
                .orElseThrow(() -> new RuntimeException("Email ou senha invalidos!"));

        if (!passwordEncoder.matches(dados.senha(), usuario.getSenha())){
            throw new RuntimeException("Email ou senha invalidos!");
        }
        return new UsuarioResponse(usuario);
    }
}

package com.example.controlegastos.controller;

import com.example.controlegastos.model.usuarios.request.LoginRequest;
import com.example.controlegastos.model.usuarios.request.UsuarioRequest;
import com.example.controlegastos.model.usuarios.response.UsuarioResponse;
import com.example.controlegastos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Cadastrar Usuario
    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<UsuarioResponse> cadastrarUsuario(@Valid @RequestBody UsuarioRequest dados){

        UsuarioResponse response = usuarioService.CadastrarUsuario(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    //Login
    @PostMapping("/login")
    @Transactional
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest dados){
        try{
            UsuarioResponse response = usuarioService.login(dados);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}

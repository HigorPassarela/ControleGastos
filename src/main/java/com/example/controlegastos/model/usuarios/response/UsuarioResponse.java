package com.example.controlegastos.model.usuarios.response;

import com.example.controlegastos.model.usuarios.Usuario;

import java.time.LocalDateTime;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String senha,
        LocalDateTime dataCadastro
) {
    public UsuarioResponse(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getDataCadastro()
        );
    }
}

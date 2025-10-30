package com.example.controlegastos.model.usuarios.request;

public record UsuarioRequest(
        String nome,
        String email,
        String senha
) {
}

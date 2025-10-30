package com.example.controlegastos.model.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    @Id
    private Long id;

    private String nome;

    private String email;

    private String senha;

    private LocalDateTime dataCadastro;
}

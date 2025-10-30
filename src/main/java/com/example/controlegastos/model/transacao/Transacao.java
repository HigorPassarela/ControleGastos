package com.example.controlegastos.model.transacao;

import com.example.controlegastos.enums.Categoria;
import com.example.controlegastos.enums.Tipo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transacao {

    @Id
    private Long id;
    private String descricao;
    private Double valor;
    private LocalDateTime data;
    private Tipo tipo;
    private Categoria categoria;

}

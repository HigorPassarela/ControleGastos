package com.example.controlegastos.model.transacao.request;

import com.example.controlegastos.enums.Categoria;
import com.example.controlegastos.enums.Tipo;

import java.time.LocalDateTime;

public record TransacaoRequest(
        String descricao,
        Double valor,
        LocalDateTime data,
        Tipo tipo,
        Categoria categoria
) {
}

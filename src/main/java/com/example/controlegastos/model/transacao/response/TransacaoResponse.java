package com.example.controlegastos.model.transacao.response;

import com.example.controlegastos.enums.Categoria;
import com.example.controlegastos.enums.Tipo;
import com.example.controlegastos.model.transacao.Transacao;

import java.time.LocalDateTime;

public record TransacaoResponse(
        Long id,
        String descricao,
        Double valor,
        LocalDateTime data,
        Tipo tipo,
        Categoria categoria
) {
    public TransacaoResponse(Transacao transacao) {
        this(
                transacao.getId(),
                transacao.getDescricao(),
                transacao.getValor(),
                transacao.getData(),
                transacao.getTipo(),
                transacao.getCategoria()
        );
    }
}

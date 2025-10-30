package com.example.controlegastos.service;

import com.example.controlegastos.model.transacao.Transacao;
import com.example.controlegastos.model.transacao.request.TransacaoRequest;
import com.example.controlegastos.model.transacao.response.TransacaoResponse;
import com.example.controlegastos.repository.TransacaoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

    public final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    //Cadastrar Transacao
    public TransacaoResponse cadastrarTransacao(@Valid TransacaoRequest dados){

        Transacao transacao = Transacao.builder()
                .descricao(dados.descricao())
                .valor(dados.valor())
                .tipo(dados.tipo())
                .categoria(dados.categoria())
                .data(dados.data())
                .build();

        transacaoRepository.save(transacao);
        return new TransacaoResponse(transacao);
    }
}

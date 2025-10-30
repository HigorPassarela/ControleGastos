package com.example.controlegastos.controller;

import com.example.controlegastos.model.transacao.request.TransacaoRequest;
import com.example.controlegastos.model.transacao.response.TransacaoResponse;
import com.example.controlegastos.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    //Cadastrar Transacao
    @PostMapping("/Cadastrar")
    public ResponseEntity<TransacaoResponse> cadastrarTransacao(@RequestBody TransacaoRequest dados){

        TransacaoResponse response = transacaoService.cadastrarTransacao(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}

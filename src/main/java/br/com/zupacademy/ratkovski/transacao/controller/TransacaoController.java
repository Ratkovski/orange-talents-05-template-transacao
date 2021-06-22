package br.com.zupacademy.ratkovski.transacao.controller;


import br.com.zupacademy.ratkovski.transacao.modelo.Cartao;
import br.com.zupacademy.ratkovski.transacao.modelo.Transacao;
import br.com.zupacademy.ratkovski.transacao.repository.CartaoRepository;
import br.com.zupacademy.ratkovski.transacao.repository.TransacaoRepository;
import br.com.zupacademy.ratkovski.transacao.response.EventoDeTransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TransacaoController {

    @Autowired
     private TransacaoRepository transacaoRepository;
    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/cartoes/{id}")
    public ResponseEntity<?>consultar(@PathVariable("id") String id){
        Optional<Cartao> cartaoExists = cartaoRepository.findById(id);

        if(cartaoExists.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão não encontrado");
        }
        List<Transacao> last10operacoes = transacaoRepository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(id);
        return ResponseEntity.ok(last10operacoes.stream().map(EventoDeTransacaoResponse::new));

    }

}

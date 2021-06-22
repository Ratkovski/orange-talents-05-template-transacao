package br.com.zupacademy.ratkovski.transacao.events;

import br.com.zupacademy.ratkovski.transacao.modelo.Transacao;
import br.com.zupacademy.ratkovski.transacao.request.CartaoRequest;
import br.com.zupacademy.ratkovski.transacao.request.EstabelecimentoResquest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoResquest estabelecimento;
    private CartaoRequest cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public EventoDeTransacao(){

    }

    public EventoDeTransacao(String id,
                             BigDecimal valor,
                             EstabelecimentoResquest estabelecimento,
                             CartaoRequest cartao,
                             LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }


    public Transacao toModel(){
        //Cartao cartao = this.cartao.toModel();
        //Estabelecimento estabelecimento = this.estabelecimento.toModel();
        return new Transacao(id,valor,estabelecimento.toModel(),cartao.toModel(),efetivadaEm);


    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoResquest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoRequest getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}

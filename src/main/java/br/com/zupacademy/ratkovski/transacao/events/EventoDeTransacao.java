package br.com.zupacademy.ratkovski.transacao.events;

import br.com.zupacademy.ratkovski.transacao.modelo.Transacao;
import br.com.zupacademy.ratkovski.transacao.response.CartaoResponse;
import br.com.zupacademy.ratkovski.transacao.response.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {
    private String id;
    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public EventoDeTransacao(){

    }

    public EventoDeTransacao(String id,
                             BigDecimal valor,
                             EstabelecimentoResponse estabelecimento,
                             CartaoResponse cartao,
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

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}

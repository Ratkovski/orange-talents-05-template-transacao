package br.com.zupacademy.ratkovski.transacao.response;

import br.com.zupacademy.ratkovski.transacao.modelo.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacaoResponse {

    private BigDecimal valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;


    public EventoDeTransacaoResponse(Transacao transacao) {
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
        this.cartao = new CartaoResponse(transacao.getCartao());
        this.efetivadaEm = transacao.getEfetivadaEm();
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

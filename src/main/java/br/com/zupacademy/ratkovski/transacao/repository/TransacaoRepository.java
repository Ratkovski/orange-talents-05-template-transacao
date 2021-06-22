package br.com.zupacademy.ratkovski.transacao.repository;

import br.com.zupacademy.ratkovski.transacao.modelo.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    //Page<Transacao>findByCartaoId(String idCartao, Pageable paginacao);
    List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String idCartao);
}

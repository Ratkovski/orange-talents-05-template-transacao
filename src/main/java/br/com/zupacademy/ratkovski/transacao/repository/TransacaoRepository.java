package br.com.zupacademy.ratkovski.transacao.repository;

import br.com.zupacademy.ratkovski.transacao.modelo.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}

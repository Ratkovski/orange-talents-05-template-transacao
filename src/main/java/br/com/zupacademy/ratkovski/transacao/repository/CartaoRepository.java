package br.com.zupacademy.ratkovski.transacao.repository;

import br.com.zupacademy.ratkovski.transacao.modelo.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}

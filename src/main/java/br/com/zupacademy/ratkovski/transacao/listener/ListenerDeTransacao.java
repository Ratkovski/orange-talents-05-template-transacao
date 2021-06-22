package br.com.zupacademy.ratkovski.transacao.listener;

import br.com.zupacademy.ratkovski.transacao.events.EventoDeTransacao;
import br.com.zupacademy.ratkovski.transacao.repository.TransacaoRepository;
import br.com.zupacademy.ratkovski.transacao.modelo.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
   private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void ouvir(EventoDeTransacao evento){
        System.out.println(evento);
        Transacao transacao = evento.toModel();
        //transacaoRepository.save(evento.toModel());
        transacaoRepository.save(transacao);
    }

    @Bean
    JsonMessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }

}

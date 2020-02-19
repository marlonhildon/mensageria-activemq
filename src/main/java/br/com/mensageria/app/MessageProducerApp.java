package br.com.mensageria.app;

import br.com.mensageria.config.AppConfig;
import br.com.mensageria.producer.MessageSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {

    private static Logger log = LoggerFactory.getLogger(MessageProducerApp.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageSender messageSender = context.getBean(MessageSender.class);
        messageSender.sendMessage("Enviando mensagem para teste de mensageria");
        log.info("Mensagem enviada com sucesso!");
        ((AbstractApplicationContext)context).close();
    }

}

package br.com.mensageria.app;

import br.com.mensageria.config.AppConfig;
import br.com.mensageria.receiver.MessageReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageConsumerApp {

    private static Logger log = LoggerFactory.getLogger(MessageConsumerApp.class);

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");
        String response = messageReceiver.receiveMessage();
        log.info("Mensagem recebida: {}", response);
        ((AbstractApplicationContext)context).close();
    }

}

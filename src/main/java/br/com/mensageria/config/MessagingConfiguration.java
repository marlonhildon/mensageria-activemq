package br.com.mensageria.config;

import br.com.mensageria.receiver.MessageReceiver;
import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.ConnectionFactory;
import java.util.Arrays;

@Configuration
public class MessagingConfiguration {
    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
    private static final String MESSAGE_QUEUE = "mensageria_fila";

    @Autowired
    MessageReceiver messageReceiver;

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("br.com.mensageria"));
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(this.connectionFactory());
        template.setDefaultDestinationName(MESSAGE_QUEUE);
        return template;
    }

    @Bean
    public MessageConverter converter() {
        return new SimpleMessageConverter();
    }
}

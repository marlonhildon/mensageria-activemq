package br.com.mensageria.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "br.com.mensageria")
@Import({MessagingConfiguration.class})
public class AppConfig {

}

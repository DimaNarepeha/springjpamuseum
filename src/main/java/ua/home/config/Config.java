package ua.home.config;

import ua.home.service.GameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ua.home")
public class Config {

    @Bean
    public GameService gameService() {
        return new GameService();
    }
}

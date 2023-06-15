package config;

import login.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public LoginController loginController() {
        return new LoginController();
    }
}

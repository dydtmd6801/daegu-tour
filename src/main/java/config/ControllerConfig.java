package config;

import login.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import regist.RegistController;

@Configuration
public class ControllerConfig {

    @Bean
    public LoginController loginController() {
        return new LoginController();
    }

    @Bean
    public RegistController registController() {
        return new RegistController();
    }
}

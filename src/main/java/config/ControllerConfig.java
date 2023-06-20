package config;

import dao.MemberDao;
import login.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import regist.RegistController;

@Configuration
public class ControllerConfig {

    private DBConfig dbConfig = new DBConfig();

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dbConfig.dataSource());
    }

    @Bean
    public LoginController loginController() {
        return new LoginController();
    }

    @Bean
    public RegistController registController() {
        return new RegistController();
    }
}

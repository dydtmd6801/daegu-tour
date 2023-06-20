package config;

import dao.MemberDao;
import login.LoginController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import regist.RegistController;
import regist.RegistService;

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
        RegistController controller = new RegistController();
        controller.setRegistService(new RegistService(memberDao()));
        return controller;
    }
}

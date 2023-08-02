package config;

import board.BoardController;
import board.BoardDao;
import board.BoardService;
import regist.MemberDao;
import index.IndexController;
import login.LoginController;
import login.LoginService;
import login.NaverLoginBO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import regist.RegistController;
import regist.RegistService;
import tour.TourController;

@Configuration
@PropertySource("classpath:keyConfig.properties")
public class ControllerConfig {

    private DBConfig dbConfig = new DBConfig();

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dbConfig.dataSource());
    }

    @Bean
    public BoardDao boardDao() {
        return new BoardDao(dbConfig.dataSource());
    }

    @Bean
    public NaverLoginBO naverLoginBO() {
        return new NaverLoginBO();
    }

    @Bean
    public LoginService loginService() {
        return new LoginService(memberDao());
    }

    @Bean
    public BoardService boardService() {
        return new BoardService(boardDao());
    }

    @Bean
    public LoginController loginController() {
        LoginController controller = new LoginController();
        controller.setLoginService(loginService());
        return controller;
    }

    @Bean
    public RegistController registController() {
        RegistController controller = new RegistController();
        controller.setRegistService(new RegistService(memberDao()));
        return controller;
    }

    @Bean
    public TourController tourController() {
        return new TourController();
    }

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

    @Bean
    public BoardController boardController() {
        BoardController controller = new BoardController();
        controller.setBoardService(boardService());
        return controller;
    }
}

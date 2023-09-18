package config;

import board.*;
import change.user.ChangeUserInfoController;
import change.user.info.ChangeUserInfoService;
import login.LogoutController;
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
import regist.SendMailService;
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
    public PagingDto pagingDto() {
        return new PagingDto();
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
    public PagingService pagingService() {
        return new PagingService(pagingDto(), boardDao());
    }

    @Bean
    public SendMailService sendMailService() {
        return new SendMailService();
    }

    @Bean
    public ChangeUserInfoService changeUserInfoService() {
        return new ChangeUserInfoService(memberDao());
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
        controller.setBoardService(boardService(), pagingService());
        return controller;
    }

    @Bean
    public LogoutController logoutController() {
        return new LogoutController();
    }

    @Bean
    public ChangeUserInfoController changeUserInfoController() {
        ChangeUserInfoController controller = new ChangeUserInfoController(changeUserInfoService());
        return controller;
    }
}

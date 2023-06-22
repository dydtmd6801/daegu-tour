import config.DBConfig;
import dao.MemberDao;
import login.LoginDto;
import login.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regist.RegistDto;
import regist.RegistService;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginServiceTest {

    private MemberDao memberDao;
    private LoginService loginService;

    @BeforeEach
    public void beforeEach() {
        memberDao = new MemberDao(new DBConfig().dataSource());
        loginService = new LoginService(memberDao);
    }

    @Test
    public void loginTest() {
        LoginDto loginInfo = new LoginDto();
        loginInfo.setUserId("test");
        loginInfo.setUserPassword("1234");
        RegistDto memberInfo = loginService.Login(loginInfo);

        assertThat(loginInfo.getUserId()).isEqualTo(memberInfo.getUserId());
    }
}

import config.DBConfig;
import dao.MemberDao;
import exception.MemberNotFoundException;
import exception.NotMatchPasswordException;
import login.LoginDto;
import login.LoginService;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regist.RegistDto;
import regist.RegistService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    public void loginFailTest1() {
        LoginDto loginInfo = new LoginDto();
        loginInfo.setUserId("aabbcc");
        loginInfo.setUserPassword("aabbcc");

        assertThatThrownBy(() -> loginService.Login(loginInfo)).isInstanceOf(MemberNotFoundException.class);
    }

    @Test
    public void loginFailTest2() {
        LoginDto loginInfo = new LoginDto();
        loginInfo.setUserId("test");
        loginInfo.setUserPassword("1111");

        assertThatThrownBy(() -> loginService.Login(loginInfo)).isInstanceOf(NotMatchPasswordException.class);
    }
}

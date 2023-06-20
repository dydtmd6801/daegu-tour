import config.DBConfig;
import dao.MemberDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import regist.RegistDto;
import regist.RegistService;

import java.lang.reflect.Member;

public class RegistServiceTest {

    private MemberDao memberDao;
    private RegistService registService;

    @BeforeEach
    public void beforeEach() {
        memberDao = new MemberDao(new DBConfig().dataSource());
        registService = new RegistService(memberDao);
    }

    @Test
    public void joinTest() {
        RegistDto newMember = new RegistDto();
        newMember.setUserId("admin");
        newMember.setPassword("admin");
        newMember.setName("운영자");
        newMember.setPhoneNumber("010-1122-3344");
        registService.join(newMember);
    }

}

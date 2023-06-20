import config.DBConfig;
import dao.MemberDao;
import exception.DuplicateMemberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regist.RegistDto;
import regist.RegistService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    public void failJoinTest() {
        joinTest();

        RegistDto newMember = new RegistDto();
        newMember.setUserId("admin");
        newMember.setPassword("admin");
        newMember.setName("운영자");
        newMember.setPhoneNumber("010-1122-3344");

        assertThatThrownBy(() -> registService.join(newMember)).isInstanceOf(DuplicateMemberException.class);
    }

}

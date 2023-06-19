package dao;

import config.DBConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import regist.RegistDto;

public class MemberDaoTest {

    private MemberDao memberDao;

    @BeforeEach
    public void beforeEach() {
        DBConfig dbConfig = new DBConfig();
        memberDao = new MemberDao(dbConfig.dataSource());
    }

    @Test
    public void insertTest() {
        RegistDto registDto = new RegistDto();
        registDto.setUserId("test");
        registDto.setPassword("1234");
        registDto.setName("홍길동");
        registDto.setPhoneNumber("010-1111-2222");
        memberDao.insert(registDto);
    }
}

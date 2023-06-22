package login;

import dao.MemberDao;
import exception.MemberNotFoundException;
import exception.NotMatchPasswordException;
import regist.RegistDto;

public class LoginService {

    private MemberDao memberDao;

    public LoginService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public RegistDto Login(LoginDto loginDto) {
        RegistDto memberInfo = memberDao.findById(loginDto.getUserId());
        if(memberInfo == null) {
            throw new MemberNotFoundException();
        }
        if(!loginDto.getUserPassword().equals(memberInfo.getPassword())) {
            throw new NotMatchPasswordException();
        }
        return memberInfo;
    }
}

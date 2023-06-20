package regist;

import dao.MemberDao;
import exception.DuplicateMemberException;

public class RegistService {

    private MemberDao memberDao;

    public RegistService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void join(RegistDto registDto) {
        RegistDto member = memberDao.findById(registDto.getUserId());
        if(member != null) {
            throw new DuplicateMemberException();
        }
        memberDao.insert(registDto);
    }
}

package regist;

import dao.MemberDao;
import exception.DuplicateMemberException;

public class RegistService {

    private MemberDao memberDao;

    public RegistService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public void checkDuplication(String userId) {
        RegistDto member = memberDao.findById(userId);
        if(member != null) {
            throw new DuplicateMemberException();
        }
    }

    public void join(RegistDto registDto) {
        memberDao.insert(registDto);
    }
}

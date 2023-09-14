package change.user.info;

import regist.MemberDao;
import regist.RegistDto;

public class ChangeUserInfoService {

    private MemberDao memberDao;

    public ChangeUserInfoService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public RegistDto authByPassword(String id, String password) {
        RegistDto memberInfo = memberDao.findById(id);
        if (!memberInfo.getPassword().equals(password)) {
            return null;
        }
        return memberInfo;
    }

    public RegistDto getUserInfo(String userId) {
        return memberDao.findById(userId);
    }
}

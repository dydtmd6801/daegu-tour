package change.user;

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

    public void updateInfo(ChangeUserInfoDto changeUserInfoDto) {
        memberDao.changeUserInfo(changeUserInfoDto);
    }

    public void updatePassword(String password, String id) {
        memberDao.changeUserPassword(password, id);
    }
}

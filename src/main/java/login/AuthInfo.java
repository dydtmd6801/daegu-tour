package login;

public class AuthInfo {

    private String userId;
    private String userName;
    private String userPhoneNumber;

    public AuthInfo(String userId, String userName, String userPhoneNumber) {
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
}

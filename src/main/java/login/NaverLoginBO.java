package login;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

public class NaverLoginBO {
    /*
    client_id, client_secret: 애플리 케이션 등록 후 받은 개인 키
    redirect_uri: 네이버 로그인 인증의 결과를 전달받을 콜백 url
    session_state: 애플리케이션이 생성한 상태 토큰
     */
    private static String CLIENT_ID;
    private static String CLIENT_SECRET;

    @Value("${naver-CLIENT-ID}")
    private void setValueClientId(String clientId) {
        CLIENT_ID = clientId;
    }

    @Value("${naver-CLIENT-SECRET}")
    private void setValueClientSecret(String clientSecret) {
        CLIENT_SECRET = clientSecret;
    }
    private final static String REDIRECT_URI = "http://localhost:8080/login/callback";
    private final static String SESSION_STATE = "oauth_state";
    /* 프로필 조회 API URL */
    private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";

    /* 네이버 아이디로 URL 생성 Method */
    public String getAuthorizationUrl(HttpSession session) {
        /* 세션 유효성 검증을 위하여 난수 생성 */
        String state = generateRandomString();
        /* 생성한 난수 값을 세션에 저장 */
        setSession(session, state);

        /* Scribe library에서 제공하는 인증 URL 생성 기능을 이용하여 네이버 아이디 로그인 URL 생성 */
        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .state(state) /* 앞에서 생성한 난수값을 인증 URL 생성시 사용 */
                .build(NaverLoginApi.instance());

        return oauthService.getAuthorizationUrl();
    }

    /* 네이버 아이디로 Callback 처리 및 AccessToken 획득 Method */
    public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {

        /* Callback으로 전달받은 세션검증용 난수값과 세션에 저장되어있는 값이 일치하는지 확인 */
        String sessionState = getSession(session);
        if(StringUtils.pathEquals(sessionState, state)) {

            OAuth20Service oauthService = new ServiceBuilder()
                    .apiKey(CLIENT_ID)
                    .apiSecret(CLIENT_SECRET)
                    .callback(REDIRECT_URI)
                    .state(state)
                    .build(NaverLoginApi.instance());

            /* Scribe library에서 제공하는 AccessToken 획득 기능으로 네이버 아이디 로그인 Access Token을 획득 */
            OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
            return accessToken;
        }
        return null;
    }

    private String generateRandomString() {
        return UUID.randomUUID().toString();
    }

    private void setSession(HttpSession session, String state) {
        session.setAttribute(SESSION_STATE, state);
    }

    private String getSession(HttpSession session) {
        return (String) session.getAttribute(SESSION_STATE);
    }

    public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException {
        OAuth20Service oauthService = new ServiceBuilder()
                .apiKey(CLIENT_ID)
                .apiSecret(CLIENT_SECRET)
                .callback(REDIRECT_URI)
                .build(NaverLoginApi.instance());

        OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
        oauthService.signRequest(oauthToken, request);
        Response response = request.send();
        return response.getBody();
    }
}

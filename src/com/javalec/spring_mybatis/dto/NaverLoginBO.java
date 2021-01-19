package com.javalec.spring_mybatis.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

public class NaverLoginBO {
	/* �씤利� �슂泥�臾몄쓣 援ъ꽦�븯�뒗 �뙆�씪誘명꽣 */
//client_id: �븷�뵆由ъ��씠�뀡 �벑濡� �썑 諛쒓툒諛쏆� �겢�씪�씠�뼵�듃 �븘�씠�뵒
//response_type: �씤利� 怨쇱젙�뿉 ���븳 援щ텇媛�. code濡� 媛믪씠 怨좎젙�뤌 �엳�뒿�땲�떎.
//redirect_uri: �꽕�씠踰� 濡쒓렇�씤 �씤利앹쓽 寃곌낵瑜� �쟾�떖諛쏆쓣 肄쒕갚 URL(URL �씤肄붾뵫). �븷�뵆由ъ��씠�뀡�쓣 �벑濡앺븷 �븣 Callback URL�뿉 �꽕�젙�븳 �젙蹂댁엯�땲�떎.
//state: �븷�뵆由ъ��씠�뀡�씠 �깮�꽦�븳 �긽�깭 �넗�겙
	private final static String CLIENT_ID = "f8XApgy8Ep8jj6xA4AyA";
	private final static String CLIENT_SECRET = "UsXop1Sd7S";
	private final static String REDIRECT_URI = "http://3.34.21.104:8080/rprojectendpoint3/callback";
	private final static String SESSION_STATE = "oauth_state";
	/* �봽濡쒗븘 議고쉶 API URL */
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";

	/* �꽕�씠踰� �븘�씠�뵒濡� �씤利� URL �깮�꽦 Method */
	public String getAuthorizationUrl(HttpSession session) {
		/* �꽭�뀡 �쑀�슚�꽦 寃�利앹쓣 �쐞�븯�뿬 �궃�닔瑜� �깮�꽦 */
		String state = generateRandomString();
		/* �깮�꽦�븳 �궃�닔 媛믪쓣 session�뿉 ���옣 */
		setSession(session, state);
		/* Scribe�뿉�꽌 �젣怨듯븯�뒗 �씤利� URL �깮�꽦 湲곕뒫�쓣 �씠�슜�븯�뿬 �꽕�븘濡� �씤利� URL �깮�꽦 */
		OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI).state(state) // �븵�꽌 �깮�꽦�븳 �궃�닔媛믪쓣 �씤利� URL�깮�꽦�떆 �궗�슜�븿
				.build(NaverLoginApi.instance());
		return oauthService.getAuthorizationUrl();
	}

	/* �꽕�씠踰꾩븘�씠�뵒濡� Callback 泥섎━ 諛� AccessToken �쉷�뱷 Method */
	public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {
		/* Callback�쑝濡� �쟾�떖諛쏆� �꽭�꽑寃�利앹슜 �궃�닔媛믨낵 �꽭�뀡�뿉 ���옣�릺�뼱�엳�뒗 媛믪씠 �씪移섑븯�뒗吏� �솗�씤 */
		String sessionState = getSession(session);
		if (StringUtils.pathEquals(sessionState, state)) {
			OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET)
					.callback(REDIRECT_URI).state(state).build(NaverLoginApi.instance());
			/* Scribe�뿉�꽌 �젣怨듯븯�뒗 AccessToken �쉷�뱷 湲곕뒫�쑝濡� �꽕�븘濡� Access Token�쓣 �쉷�뱷 */
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
			return accessToken;
		}
		return null;
	}

	/* �꽭�뀡 �쑀�슚�꽦 寃�利앹쓣 �쐞�븳 �궃�닔 �깮�꽦湲� */
	private String generateRandomString() {
		return UUID.randomUUID().toString();
	}

	/* http session�뿉 �뜲�씠�꽣 ���옣 */
	private void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}

	/* http session�뿉�꽌 �뜲�씠�꽣 媛��졇�삤湲� */
	private String getSession(HttpSession session) {
		return (String) session.getAttribute(SESSION_STATE);
	}

	/* Access Token�쓣 �씠�슜�븯�뿬 �꽕�씠踰� �궗�슜�옄 �봽濡쒗븘 API瑜� �샇異� */
	public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException {
		OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI).build(NaverLoginApi.instance());
		OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
		oauthService.signRequest(oauthToken, request);
		Response response = request.send();
		return response.getBody();
	}
	

		
		 
		  

	
	
}

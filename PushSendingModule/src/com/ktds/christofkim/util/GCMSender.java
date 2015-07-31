package com.ktds.christofkim.util;
/**
 * Team Highfive
 * Original source: Google GCM example
 * 
 * Republished by Taehoon Kim (2015-07-31)
 * Supported by MinChang Jang(kt ds lecturer)
 * https://console.developers.google.com/project/shoppingbellpush
 * 
 * 사전 준비: 구글 계정 필요
 * 
 * 사용방법.
 * 		0. 아래 웹 실행(GCM등록 홈피)
 * 			https://developers.google.com/mobile/add?platform=android&cntapi=gcm&cntapp=YourAppTitle&cntpkg=com.ktds.yourpacakge&cnturl=https:%2F%2Fdevelopers.google.com%2Fcloud-messaging%2Fandroid%2Fstart%3Fconfigured%3Dtrue&cntlbl=Continue%20Try%20Cloud%20Messaging
 *
 * 		1. AppName 적기(이 이름으로 https://console.developers.google.com)에 프로젝트 이름이 등록됨
 * 
 * 		2. Android package name 적기
 * 
 * 		자기의 패키지 이름이 com.ktds.mypack이라면 
 * 		com.ktds.mypack를 입력(입력하지 않으면 동작 안함)
 * 		
 * 		3. CONTINUE TO Choose and configure services 클릭
 * 
 * 		4. 생성되면 GCM(Google Cloud Messaging)을 활성화 하기 위하여
 * 			ENABLE GOOGLE CLOUD MESSAGING 파란 버튼 클릭
 * 
 * 		Server API Key
			AIzaSyD3IrGaW-rx4ggQbFOwkmJQMJb0tJoBa-0
		Sender ID
			707212709906
			
		이런식으로 생성됨
		
		//아래 내용은 안드로이드 설정시
		 * 
		5. 생성된 API, Sender ID를 JSON 타입을 받기 위하여, 
		CONTINUE TO Generate configuration files 클릭 후
		Download google-sevices.json 받고
		
		6. AndroidStudio에서 Project를 클릭
		7. App 아래에 google-services.json을 복사
		
		예제: 프로젝트 이름이 AppPro일때 json을 복사한 경로
		
		AppPro
			└ App
				└----- google-services.json(copy)
				
		//아래 내용은 서버에서 사용시
		 
		API_KEY를 AIzaSyD3IrGaW-rx4ggQbFOwkmJQMJb0tJoBa-0로 변경
		
		8. message[0]에 전달하고자 하는 메세지 입력
		9. message[1]은 전달하고자 하는 단말한테 등록(이 경우 단말의 토큰을 알아야 하며, 주석 처리 할 경우 shoppingBell에 등록된 모든 단말에게
		메세지를 보냄
		
		끝.
 * 
 * */
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GCMSender {
	//구글 GCM 서버에서 발급받은 Key
	public static final String API_KEY = "AIzaSyAcv-_ORJeufjiGV3CR90OFBtgse7Un0as";	
	public static void main(String[] args) {
		String []message = new String[2];
		//Multicast(즉 서버에 모두 등록된 단말에 대하여 메세지를 보냄)
		message[0] = "쇼핑정보가 메일로 도착하였습니다.";
		//Unicast(즉 한 단말기만과 통신할 경우 주석 해제, 이 경우 등록된 폰에게만 메세지를 보냅니다. (토큰을 알아야됨 ) )
		//message[1] = "c1l11TocSKg:APA91bFPUispprNIMXyK9RUdiLarbYuPegIkT9RhRzX53pW7jfHzOOWtzI6d-pdwl2R--8kW4gWAX2E-qO9GE3UbBHZMdWKCMQrDsnUypI4Y9kvItl61BSb2KEMPjz_HCVvLtDvf9Ts9";
		new GCMSender().sendData(message);
	}
	
	public void sendData(String[] myOption) {
		try {
			// Prepare JSON containing the GCM message content. What to send and
			// where to send.
			JSONObject jGcmData = new JSONObject();
			JSONObject jData = new JSONObject();
			jData.put("message", myOption[0].trim());
			// Where to send GCM message.
			if (myOption.length > 1 && myOption[1] != null) {
				jGcmData.put("to", myOption[1].trim());
			} else {
				jGcmData.put("to", "/topics/global");
			}
			// What to send in GCM message.
			jGcmData.put("data", jData);

			// Create connection to send GCM Message request.
			URL url = new URL("https://android.googleapis.com/gcm/send");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Authorization", "key=" + API_KEY);
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);

			// Send GCM message content.
			OutputStream outputStream = conn.getOutputStream();
			outputStream.write(jGcmData.toString().getBytes());

			// Read GCM response.
			InputStream inputStream = conn.getInputStream();
			String resp = IOUtils.toString(inputStream);
			System.out.println(resp);
			System.out
					.println("Check your device/emulator for notification or logcat for "
							+ "confirmation of the receipt of the GCM message.");
		} catch (IOException e) {
			System.out.println("Unable to send GCM message.");
			System.out
					.println("Please ensure that API_KEY has been replaced by the server "
							+ "API key, and that the device's registration token is correct (if specified).");
			e.printStackTrace();
		}
	}
}

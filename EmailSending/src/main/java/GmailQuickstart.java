/**
 * Google Gmail API를 이용한 메일 전송
 * 
 * 2015-05-20 
 * 
 * @author TaeHoon Kim(Christof-kim)
 * 
 * TODO:
 * 	Step1. Google Site에서 API-Project 생성 (예제 : stone-host-95102)
 * 
 *  Step2. https://console.developers.google.com/project/stone-host-95102
 *  
 *  에서 APIs & auth --> Credentials --> Create new Client ID 생성
 *  Step3. Installed Application --> Others --> Create Client ID 생성
 *  
 *  Step4. Client ID for native application 카테고리의 Download JSON 클릭(인증 파일 다운됨)
 *  
 *  Step5. 필요한 maven repository 설정
 *  
 *  <dependencies>
		<dependency>
			<groupId>com.google.apis</groupId>
			<artifactId>google-api-services-gmail</artifactId>
			<version>v1-rev29-1.20.0</version>
		</dependency>
		<dependency>
			<groupId>com.google.oauth-client</groupId>
			<artifactId>google-oauth-client-jetty</artifactId>
			<version>1.11.0-beta</version>
		</dependency>
		<dependency>
			<groupId>javax.mail</groupId>
			<artifactId>javax.mail-api</artifactId>
			<version>1.5.3</version>
		</dependency>
		<dependency>
			<groupId>com.sun.mail</groupId>
			<artifactId>javax.mail</artifactId>
			<version>1.5.3</version>
		</dependency>
	</dependencies>
	
	Step6. API에 접근하기 위한 권한 설정
	
	public class GmailQuickstart { 
	 	
	 	...
	 	
		private static final List<String> SCOPES = Arrays
				.asList(GmailScopes.GMAIL_LABELS	//라벨권한
						,GmailScopes.GMAIL_INSERT	//데이터 삽입 권한
						,GmailScopes.GMAIL_MODIFY	//데이터 수정 권한
						,GmailScopes.GMAIL_COMPOSE	//데이터 COMPOSSE
						,GmailScopes.MAIL_GOOGLE_COM);	//GMAIL GOOGLE 권한
	}
	
	Step7. 다운받은 client_secret.json(이름 변경 필요)을 src/main/resources에 삽입
	
	Step8. / 받는 사람 /  보내는 사람 / 메일 제목  / 메일 내용 적고 실행.. 끝. 
	
									받는 사람 / 				보내는 사람 			/ 메일 제목/			 메일 내용 /
	MimeMessage mm = createEmail("taehun3718@naver.com","taehun3718@gmail.com", "뭐지!? 테스트입니다.", "테스트");
				
							gmail계정			
	sendMessage(service, "taehun3718@gmail.com", mm);
 *  
 */
//https://console.developers.google.com/project/stone-host-95102


//https://developers.google.com/api-client-library/java/
//http://mvnrepository.com/artifact/com.google.oauth-client/google-oauth-client-jetty/1.11.0-beta
//http://mvnrepository.com/artifact/javax.mail/javax.mail-api/1.5.3
//https://github.com/google/google-api-java-client-samples/blob/master/oauth2-cmdline-sample/src/main/java/com/google/api/services/samples/oauth2/cmdline/OAuth2Sample.java

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailQuickstart {
	/** Application name. */
	private static final String APPLICATION_NAME = "Quick start";

	/** Directory to store user credentials. */
	private static final java.io.File DATA_STORE_DIR = new java.io.File(
			System.getProperty("user.home"),".credentials/gmail-api-quickstart");

	/** Global instance of the {@link FileDataStoreFactory}. */
	private static FileDataStoreFactory DATA_STORE_FACTORY;

	/** Global instance of the JSON factory. */
	private static final JsonFactory JSON_FACTORY = JacksonFactory
			.getDefaultInstance();

	/** Global instance of the HTTP transport. */
	private static HttpTransport HTTP_TRANSPORT;

	/** Global instance of the scopes required by this quickstart. */
//	private static final List<String> SCOPES = Arrays
//			.asList(GmailScopes.GMAIL_LABELS);
	private static final List<String> SCOPES = Arrays
			.asList(GmailScopes.GMAIL_LABELS
					,GmailScopes.GMAIL_INSERT
					,GmailScopes.GMAIL_MODIFY
					,GmailScopes.GMAIL_COMPOSE
					,GmailScopes.MAIL_GOOGLE_COM);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Creates an authorized Credential object.
	 * 
	 * @return an authorized Credential object.
	 * @throws Exception
	 */
	public static Credential authorize() throws Exception {
		// Load client secrets.
		InputStream in = GmailQuickstart.class
				.getResourceAsStream("/client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
				JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
				.setDataStoreFactory(DATA_STORE_FACTORY)
				.setAccessType("offline").build();
				
		Credential credential = new AuthorizationCodeInstalledApp(flow,
				new LocalServerReceiver()).authorize("user");
		System.out.println("Credentials saved to "
				+ DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}

	/**
	 * Build and return an authorized Gmail client service.
	 * 
	 * @return an authorized Gmail client service
	 * @throws Exception
	 */
	public static Gmail getGmailService() throws Exception {
		Credential credential = authorize();
		return new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

	/**
	 * Create draft email.
	 *
	 * @param service
	 *            an authorized Gmail API instance
	 * @param userId
	 *            user's email address. The special value "me" can be used to
	 *            indicate the authenticated user
	 * @param email
	 *            the MimeMessage used as email within the draft
	 * @return the created draft
	 * @throws MessagingException
	 * @throws IOException
	 */
	public static Draft createDraft(Gmail service, String userId,
			MimeMessage email) throws MessagingException, IOException {
		Message message = createMessageWithEmail(email);
		Draft draft = new Draft();
		draft.setMessage(message);
		draft = service.users().drafts().create(userId, draft).execute();

		System.out.println("draft id: " + draft.getId());
		System.out.println(draft.toPrettyString());
		return draft;
	}

	/**
	 * Create a message from an email
	 *
	 * @param email
	 *            Email to be set to raw of message
	 * @return a message containing a base64url encoded email
	 * @throws IOException
	 * @throws MessagingException
	 */
	public static Message createMessageWithEmail(MimeMessage email)
			throws MessagingException, IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		email.writeTo(bytes);
		String encodedEmail = Base64.encodeBase64URLSafeString(bytes
				.toByteArray());
		Message message = new Message();
		message.setRaw(encodedEmail);
		return message;
	}

	/**
	 * Create a MimeMessage using the parameters provided.
	 *
	 * @param to
	 *            email address of the receiver
	 * @param from
	 *            email address of the sender, the mailbox account
	 * @param subject
	 *            subject of the email
	 * @param bodyText
	 *            body text of the email
	 * @return the MimeMessage to be used to send email
	 * @throws MessagingException
	 */
	public static MimeMessage createEmail(String to, String from,
			String subject, String bodyText) throws MessagingException {
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		MimeMessage email = new MimeMessage(session);
		email.setFrom(new InternetAddress(from));
		
		email.addRecipient(javax.mail.Message.RecipientType.TO,
				new InternetAddress(to));
		email.setSubject(subject);
		email.setText(bodyText);
		
		return email;
	}

	public static void sendMessage(Gmail service, String userId,
			MimeMessage email) throws MessagingException, IOException {
		Message message = createMessageWithEmail(email);
		message = service.users().messages().send(userId, message).execute();

		System.out.println("Message id: " + message.getId());
		System.out.println(message.toPrettyString());
	}
	
	/**
	   * Send an existing draft to its set recipients.
	   *
	   * @param service Authorized Gmail API instance.
	   * @param userId User's email address. The special value "me"
	   * can be used to indicate the authenticated user.
	   * @param draftId ID of Draft to be sent.
	   * @throws java.io.IOException
	   */
	  public static void sendDraft(Gmail service, String userId, String draftId) throws IOException {
	      Draft draft = new Draft();
	      draft.setId(draftId);

	      // To update the Draft before sending, set a new Message on the Draft before sending.

	      Message message = service.users().drafts().send(userId, draft).execute();
	      System.out.println("Draft with ID: " + draftId + " sent successfully.");
	      System.out.println("Draft sent as Message with ID: " + message.getId());
	  }

	public static void main(String[] args) throws Exception {
		// Build a new authorized API client service.
		Gmail service = getGmailService();

		MimeMessage mm = createEmail("taehun3718@naver.com",
				"taehun3718@gmail.com", "뭐지!? 테스트입니다.", "테스트");
		sendMessage(service, "taehun3718@gmail.com", mm);

	}

}
package lsp;

public class Main {
	
	private ManagementFriends managementFriends;
	
	public void start() {
		managementFriends = new ManagementFriends();
		
		Friends friends = new Friends();
		friends.setName("친구1");
		friends.setPhone("1234567890");
		managementFriends.addFriends(friends);
		
		HighFriends highFriends = new HighFriends();
		highFriends.setName("친구2");
		highFriends.setPhone("123454");
		highFriends.setSchool("고등학교2");
		managementFriends.addFriends(highFriends);
		
		MiddleFriends  middleFriends = new MiddleFriends();
		middleFriends.setName("친구2");
		middleFriends.setPhone("123454");
		middleFriends.setSchool("고등학교2");
		managementFriends.addFriends(highFriends);

		managementFriends.showAllFriends();
		
		//서버 클래스로 먼저 선언이 되어야 함
		//슈퍼 캘르스로 캐스팅
		
	}
	
	public static void main(String[] args) {
		
		new Main().start();
	}
}

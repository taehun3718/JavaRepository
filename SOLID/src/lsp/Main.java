package lsp;

public class Main {
	
	private ManagementFriends managementFriends;
	
	public void start() {
		managementFriends = new ManagementFriends();
		
		Friends friends = new Friends();
		friends.setName("ģ��1");
		friends.setPhone("1234567890");
		managementFriends.addFriends(friends);
		
		HighFriends highFriends = new HighFriends();
		highFriends.setName("ģ��2");
		highFriends.setPhone("123454");
		highFriends.setSchool("����б�2");
		managementFriends.addFriends(highFriends);
		
		MiddleFriends  middleFriends = new MiddleFriends();
		middleFriends.setName("ģ��2");
		middleFriends.setPhone("123454");
		middleFriends.setSchool("����б�2");
		managementFriends.addFriends(highFriends);

		managementFriends.showAllFriends();
		
		//���� Ŭ������ ���� ������ �Ǿ�� ��
		//���� Ķ������ ĳ����
		
	}
	
	public static void main(String[] args) {
		
		new Main().start();
	}
}

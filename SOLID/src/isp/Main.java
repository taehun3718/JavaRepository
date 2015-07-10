package isp;

public class Main {
	
	public static void main(String[] args) {
		MemberInterface member = new Member();
		member.writeAritlce();
		member.readAritlce();
		member.updateArticle();
		member.deleteArticle();
		
		ManagerInterface manager = new Manager();
		manager.writeAritlce();
		manager.readAritlce();
		manager.updateArticle();
		manager.deleteArticle();
		manager.massiveDelete();
		manager.forceDeleteArtice();
		manager.moveToNotice();
		
	}
}

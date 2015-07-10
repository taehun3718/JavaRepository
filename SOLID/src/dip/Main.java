package dip;

public class Main {
	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		
		MemberInterface memberInterface = new Member();
		ManagerInterface managerInterface = new Manager();
		
		memberService.setManagerInterface(managerInterface);
		memberService.setMemberInterface(memberInterface);
		
		memberService.writeArticle("MANAGER");
		memberService.writeArticle("MEMBER");
	}
}

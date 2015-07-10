package dip;

public class MemberService {
	private MemberInterface memberInterface;
	private ManagerInterface managerInterface;
	
	public MemberInterface getMemberInterface() {
		return memberInterface;
	}
	
	public void setMemberInterface(MemberInterface memberInterface) {
		this.memberInterface = memberInterface;
	}
	
	public ManagerInterface getManagerInterface() {
		return managerInterface;
	}
	
	public void setManagerInterface(ManagerInterface managerInterface) {
		this.managerInterface = managerInterface;
	}
	
	public void writeArticle(String type) {
		if(type == "MANAGER") {
			managerInterface.writeAritlce();
		}
		else {
			memberInterface.writeAritlce();
		}
	}
	
}

package dip;

public class Manager extends Member implements ManagerInterface{
	@Override
	public void moveToNotice() {
		
	}
	
	@Override
	public void forceDeleteArtice() {
		System.out.println("������ ���� �����մϴ�.");
	}
	@Override
	public void massiveDelete() {
		System.out.println("�뷮�� ���� �����մϴ�.");
	}
}

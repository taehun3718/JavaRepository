package dip;

public class Manager extends Member implements ManagerInterface{
	@Override
	public void moveToNotice() {
		
	}
	
	@Override
	public void forceDeleteArtice() {
		System.out.println("강제로 글을 삭제합니다.");
	}
	@Override
	public void massiveDelete() {
		System.out.println("대량의 글을 삭제합니다.");
	}
}

package isp;

public class Member implements MemberInterface{

	@Override
	public void writeAritlce() {
		System.out.println("ȸ������ ���� ���ϴ�.");
	}

	@Override
	public void readAritlce() {
		System.out.println("ȸ������ ���� �н��ϴ�.");
	}

	@Override
	public void updateArticle() {
		System.out.println("ȸ������ ���� �����մϴ�.");
		
	}

	@Override
	public void deleteArticle() {
		System.out.println("ȸ������ ���� �����մϴ�.");
	}

}

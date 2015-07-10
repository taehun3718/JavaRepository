package isp;

public class Member implements MemberInterface{

	@Override
	public void writeAritlce() {
		System.out.println("회원으로 글을 씁니다.");
	}

	@Override
	public void readAritlce() {
		System.out.println("회원으로 글을 읽습니다.");
	}

	@Override
	public void updateArticle() {
		System.out.println("회원으로 글을 수정합니다.");
		
	}

	@Override
	public void deleteArticle() {
		System.out.println("회원으로 글을 삭제합니다.");
	}

}

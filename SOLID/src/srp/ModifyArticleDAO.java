package srp;

public class ModifyArticleDAO {
	public void modifyArticle(String id, String name, String subject) {
		System.out.println(
				String.format("%s(%s)님이 %s 글을 삭제했습니다.", name, id, subject)
				);
		
		
		
	}
}

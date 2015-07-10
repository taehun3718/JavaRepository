package srp;

public class WriteArticleDAO {
	public void writeArticle(String id, String name, String subject) {
		System.out.println(
				String.format("%s(%s)님이 %s 글을 등록했습니다.", name, id, subject)
				);
		
		
		
	}
}

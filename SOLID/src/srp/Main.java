package srp;

public class Main {

	private GetMemberInfoDAO getMemberInfoDAO;
	private WriteArticleDAO writeArticleDAO;
	private PlusPointDAO plusPointDAO;
	private ModifyArticleDAO modifyArticleDAO;
	
	public void doProcessing(String type) {
		if(type.equals("WRITE")) {
			writeArticle();
		}
		else {
			modifyArticle();
		}
	}
	
	public void writeArticle() {
		//1. 회원의 정보를 가져온다.
		String memberName = getMemberInfoDAO.getMemberInfo("admin");
		
		//2. ArticleVO에 회원의 정보를 셋팅한다.
		System.out.println(memberName + "셋팅");
		
		//3. Aritlce Insert한다
		writeArticleDAO.writeArticle("admin", memberName, "테스트");
		
		//4. 글 쓴 회원에게 Point를 지급한다.
		plusPointDAO.plusPoint("admin", 100);
		
	}
	
	public void modifyArticle() {
		//1. 회원의 정보를 가져온다.
				String memberName = getMemberInfoDAO.getMemberInfo("admin");
				
				//2. ArticleVO에 회원의 정보를 셋팅한다.
				System.out.println(memberName + "셋팅");
				
				//3. Aritlce Insert한다
				modifyArticleDAO.modifyArticle("admin", memberName, "테스트");
				
				//4. 글 쓴 회원에게 Point를 지급한다.
				plusPointDAO.plusPoint("admin", 100);
	}
}

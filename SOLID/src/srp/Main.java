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
		//1. ȸ���� ������ �����´�.
		String memberName = getMemberInfoDAO.getMemberInfo("admin");
		
		//2. ArticleVO�� ȸ���� ������ �����Ѵ�.
		System.out.println(memberName + "����");
		
		//3. Aritlce Insert�Ѵ�
		writeArticleDAO.writeArticle("admin", memberName, "�׽�Ʈ");
		
		//4. �� �� ȸ������ Point�� �����Ѵ�.
		plusPointDAO.plusPoint("admin", 100);
		
	}
	
	public void modifyArticle() {
		//1. ȸ���� ������ �����´�.
				String memberName = getMemberInfoDAO.getMemberInfo("admin");
				
				//2. ArticleVO�� ȸ���� ������ �����Ѵ�.
				System.out.println(memberName + "����");
				
				//3. Aritlce Insert�Ѵ�
				modifyArticleDAO.modifyArticle("admin", memberName, "�׽�Ʈ");
				
				//4. �� �� ȸ������ Point�� �����Ѵ�.
				plusPointDAO.plusPoint("admin", 100);
	}
}

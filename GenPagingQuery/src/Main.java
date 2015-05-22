import com.ktds.christof.util.Column;
import com.ktds.christof.util.GeneratePagingQuery;
import com.ktds.christof.util.QueryType;

import java.awt.Toolkit;
import java.awt.datatransfer.*;

/**
 * Paging Query만들기가 짜증나서 직접 만든 페이징용 쿼리 작성 콘솔 프로그램
 * @author 206-021
 *
 */
//http://dantes.kr/165 자바 클립보드 사용하는 방법
public class Main {
	public static void main(String[] args) {
		GeneratePagingQuery gpq = new GeneratePagingQuery("BOARD");
		
		gpq.addColumn(new Column(QueryType.NUMBER, "ID"));
		gpq.addColumn(new Column(QueryType.VARCHAR2, "CONTENT"));
		gpq.addColumn(new Column(QueryType.VARCHAR2, "UPLOAD_FILE"));
		gpq.addColumn(new Column(QueryType.VARCHAR2, "UPLOAD_FILE_TWO"));
		gpq.addColumn(new Column(QueryType.VARCHAR2, "UPLOAD_FILE_UUID"));
		gpq.addColumn(new Column(QueryType.VARCHAR2, "UPLOAD_FILE_TWO_UUID"));
		
		Clipboard clipboard	= Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection ss	= new StringSelection(gpq.getPagingQuery());
		
		System.out.println(gpq.getSelectQuery());
		System.out.println(gpq.getPagingQuery());
		
		clipboard.setContents(ss, null);
	}
}

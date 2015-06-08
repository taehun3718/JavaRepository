import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import com.ktds.awt.GeneratePagingQueryWindow;
import com.ktds.christof.util.Column;
import com.ktds.christof.util.GeneratePagingQuery;
import com.ktds.christof.util.QueryType;

/**
 * Paging Query만들기가 짜증나서 직접 만든 페이징용 쿼리 작성 AWT기반 프로그램
 * 2015-06-08 
 * taehun3718@gmail.com
 * 
 * @author TaeHoon Kim
 *
 */
//http://dantes.kr/165 자바 클립보드 사용하는 방법
//http://tapito.tistory.com/378 창 닫기 구현
//http://mainia.tistory.com/1554 : 익명 클래스를 이용한 창 닫기 구현
//한글이 깨질 때 대처법

public class Main {
	public static void main(String[] args) {

		new GeneratePagingQueryWindow();
		/*
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
		
		clipboard.setContents(ss, null);*/
	}
}

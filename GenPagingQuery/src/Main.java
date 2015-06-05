import com.ktds.christof.util.Column;
import com.ktds.christof.util.GeneratePagingQuery;
import com.ktds.christof.util.QueryType;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Paging Query만들기가 짜증나서 직접 만든 페이징용 쿼리 작성 콘솔 프로그램
 * @author 206-021
 *
 */
//http://dantes.kr/165 자바 클립보드 사용하는 방법
//http://tapito.tistory.com/378 창 닫기 구현
//http://mainia.tistory.com/1554 : 익명 클래스를 이용한 창 닫기 구현
//한글이 깨질 때 대처법
class FormWindow extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}

class GeneratePagingQueryWindow extends Frame{
	private static final long serialVersionUID = 9068624439553898539L;
	
	private Label label;
	private Button btnAdd;
	private Button btnAdd2;
	
	public GeneratePagingQueryWindow() {
		super();
		
		label = new Label();
		label.setAlignment(label.CENTER);
		label.setText("Query 추가");
		label.setFont(new Font("Serif", Font.PLAIN, 15));
		
		btnAdd = new Button();
		btnAdd2 = new Button();
		
		btnAdd.setName("쿼리 추가");
		btnAdd.setSize(50, 50);
		
		this.setLayout(new GridLayout(10,1));
		this.setSize(800, 600);
		this.add(label);
		this.add(btnAdd);
		this.add(btnAdd2);
		
		
		this.setVisible(true);
		this.addWindowListener(new FormWindow());
	}
	
}
public class Main {
	public static void main(String[] args) {

		
		new GeneratePagingQueryWindow();
		
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

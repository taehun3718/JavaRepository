package ocp.latest;

public class Main {
	
	private Button button;
	
	public void start() {
		button = new Button();
		button.click(new ClickEvent() {
			@Override
			public void clickEvent() {
				System.out.println("�ȳ��ϼ���");
				
			}
		});
		
		button = new Button();
		button.click(new ClickEvent() {
			@Override
			public void clickEvent() {
				System.out.println("�ȳ���������");
				
			}
		});
	}
	
	public static void main(String[] args) {
		
	}
}

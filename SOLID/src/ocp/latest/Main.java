package ocp.latest;

public class Main {
	
	private Button button;
	
	public void start() {
		button = new Button();
		button.click(new ClickEvent() {
			@Override
			public void clickEvent() {
				System.out.println("안녕하세요");
				
			}
		});
		
		button = new Button();
		button.click(new ClickEvent() {
			@Override
			public void clickEvent() {
				System.out.println("안녕히가세요");
				
			}
		});
	}
	
	public static void main(String[] args) {
		
	}
}

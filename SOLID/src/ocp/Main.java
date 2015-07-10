package ocp;

public class Main {
	private Button button;
	
	public void start() {
		button = new PrintWelcomeButton();
		button.click();
		
		button = new PrintByeButton();
		button.click();
//		
//		button = new Button() {
//			
//			@Override
//			public void doClickEvent() {
//				System.out.println("my temeplate callback");
//				
//			}
//		};
//		
//		button.click();
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}

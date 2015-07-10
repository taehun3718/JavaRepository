package ocp;

public abstract class Button {
	public void click() {
		System.out.println("버튼이 클릭되었습니다.");
		System.out.println("클릭 이벤트를 실행합니다.");
		
		doClickEvent();
		
		System.out.println("클릭 이벤트가 실행되었습니다.");
	}

	public abstract void doClickEvent();
}

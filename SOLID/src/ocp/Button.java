package ocp;

public abstract class Button {
	public void click() {
		System.out.println("��ư�� Ŭ���Ǿ����ϴ�.");
		System.out.println("Ŭ�� �̺�Ʈ�� �����մϴ�.");
		
		doClickEvent();
		
		System.out.println("Ŭ�� �̺�Ʈ�� ����Ǿ����ϴ�.");
	}

	public abstract void doClickEvent();
}

public class EnumTest {
	
	public static void main(String[] args) {
		showAnimal(Animal.CAT);
	}
	
	public static void showAnimal(Animal animal) {
		System.out.println(animal.value);
		
		if(animal == Animal.CAT) {
			System.out.println("�����");
		}
		else if(animal == Animal.DOG) {
			System.out.println("������");
		}
		else if(animal == Animal.BIRD) {
			System.out.println("��");
		}
		
		else {
			System.out.println("???");
		}
	}
}

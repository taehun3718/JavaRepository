public class EnumTest {
	
	public static void main(String[] args) {
		showAnimal(Animal.CAT);
	}
	
	public static void showAnimal(Animal animal) {
		System.out.println(animal.value);
		
		if(animal == Animal.CAT) {
			System.out.println("고앙이");
		}
		else if(animal == Animal.DOG) {
			System.out.println("강아지");
		}
		else if(animal == Animal.BIRD) {
			System.out.println("새");
		}
		
		else {
			System.out.println("???");
		}
	}
}

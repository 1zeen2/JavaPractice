package may;
//다음은 동물(ANIMAL)과 관련된 프로그램을 작성하는 문제입니다. 이 프로그램에서는 동물의 소리를 출력하는 메서드를 포함해야 합니다. 추상 클래스와 상속을 이용해 다양한 동물 클래스를 구현하세요.
//
//요구사항
//추상 클래스 ANIMAL
//
//추상 메서드 MAKESOUND(): 이 메서드는 동물의 소리를 출력합니다.
//ANIMAL 클래스를 상속받는 구체 클래스
//
//DOG 클래스
//MAKESOUND() 메서드는 "WOOF"를 출력합니다.
//CAT 클래스
//MAKESOUND() 메서드는 "MEOW"를 출력합니다.
//COW 클래스
//MAKESOUND() 메서드는 "MOO"를 출력합니다.
//메인 클래스
//
//각각의 동물 객체를 생성하고, MAKESOUND() 메서드를 호출하여 동물의 소리를 출력합니다.
abstract class Animal {
	public abstract void makesound();
	
}

class Dog extends Animal {

	@Override
	public void makesound() {
		System.out.println("WOOF");
	}
	
}

class Cat extends Animal {

	@Override
	public void makesound() {
		System.out.println("MEOW");
	}
	
}

class Cow extends Animal {

	@Override
	public void makesound() {
		System.out.println("MOO");
	}
	
}

public class Fir_24 {

	
	public static void main(String[] args) {
		Animal dog = new Dog();
		Animal cat = new Cat();
		Animal cow = new Cow();
		
		dog.makesound();
		cat.makesound();
		cow.makesound();

	}

}
